/*
 * Copyright (c) 2017, Salesforce.com, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * 3. Neither the name of Salesforce.com nor the names of its contributors may
 * be used to endorse or promote products derived from this software without
 * specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package com.salesforce.op.stages.base.unary

import com.salesforce.op.UID
import com.salesforce.op.features.Feature
import com.salesforce.op.features.types._
import com.salesforce.op.test.{TestFeatureBuilder, TestSparkContext}
import com.salesforce.op.utils.spark.RichDataset._
import org.apache.spark.ml.param.ParamMap
import org.apache.spark.sql.Dataset
import org.apache.spark.sql.types.{DoubleType, MetadataBuilder, StructField, StructType}
import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import org.scalatest.junit.JUnitRunner


@RunWith(classOf[JUnitRunner])
class UnaryEstimatorTest extends FlatSpec with TestSparkContext {

  val (ds, f1) = TestFeatureBuilder(Seq(1.0, 5.0, 3.0, 2.0, 6.0).toReal)

  val testEstimator: UnaryEstimator[Real, Real] = new MinMaxNormEstimator()

  Spec[UnaryEstimator[_, _]] should "throw an error if you try to get the output without setting the inputs" in {
    intercept[java.util.NoSuchElementException](testEstimator.getOutput())
  }

  it should "return a copy with the same uid" in {
    val newData = new MetadataBuilder().putLong("myKey", 100).build()
    val copyWithValues = testEstimator.copy(
      new ParamMap().put(testEstimator.outputMetadata, newData)
    )

    copyWithValues.isInstanceOf[UnaryEstimator[_, _]]
    copyWithValues.uid shouldBe testEstimator.uid
    copyWithValues.getMetadata() shouldBe newData
  }

  it should "return a single output feature of the correct type" in {
    val outputFeatures = testEstimator.setInput(f1).getOutput()

    outputFeatures shouldBe new Feature[Real](
      name = testEstimator.getOutputFeatureName,
      originStage = testEstimator,
      isResponse = false,
      parents = Array(f1)
    )
  }

  it should "return a UnaryModel with the estimator as the parent, a working copy method and the same uid" +
    " and the correct function" in {
    val testModel = testEstimator.setInput(f1).fit(ds)

    testModel.parent shouldBe testEstimator
    testModel.transformFn(1.0.toReal) shouldBe 0.0.toReal
    testModel.copy(new ParamMap()).uid shouldBe testEstimator.uid
  }

  it should "create a UnaryModel transformer when it is fit" in {
    val testModel = testEstimator.setInput(f1).fit(ds)
    val testDataTransformed = testModel.setInput(f1).transform(ds)
    val outputFeatures = testModel.getOutput()
    val transformedValues = testDataTransformed.collect(f1, outputFeatures)

    val expectedTypes =
      StructType(Seq(StructField(f1.name, DoubleType, true),
        StructField(outputFeatures.name, DoubleType, true)))

    testDataTransformed.schema shouldEqual expectedTypes
    transformedValues shouldEqual
      Array((1.0, 0.0), (5.0, 0.8), (3.0, 0.4), (2.0, 0.2), (6.0, 1.0)).map(v => v._1.toReal -> v._2.toReal)
  }

    it should "copy itself and the model successfully" in {
      val est = new MinMaxNormEstimator()
      val mod = new MinMaxNormEstimatorModel(0.0, 0.0, est.operationName, est.uid)

      est.copy(new ParamMap()).uid shouldBe est.uid
      mod.copy(new ParamMap()).uid shouldBe mod.uid
    }

}

class MinMaxNormEstimator(uid: String = UID[MinMaxNormEstimator])
  extends UnaryEstimator[Real, Real](operationName = "minMaxNorm", uid = uid) {

  def fitFn(dataset: Dataset[Real#Value]): UnaryModel[Real, Real] = {
    val grouped = dataset.groupBy()
    val maxVal = grouped.max().first().getDouble(0)
    val minVal = grouped.min().first().getDouble(0)
    new MinMaxNormEstimatorModel(min = minVal, max = maxVal, operationName = operationName, uid = uid)
  }
}

final class MinMaxNormEstimatorModel private[op](val min: Double, val max: Double, operationName: String, uid: String)
  extends UnaryModel[Real, Real](operationName = operationName, uid = uid) {
  def transformFn: Real => Real = _.v.map(v => (v - min) / (max - min)).toReal
}
