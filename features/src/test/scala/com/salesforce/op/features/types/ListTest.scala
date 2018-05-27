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

package com.salesforce.op.features.types

import com.salesforce.op.test.TestCommon
import org.apache.lucene.spatial3d.geom.{GeoPoint, PlanetModel}
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{Assertions, FlatSpec, Matchers}


@RunWith(classOf[JUnitRunner])
class ListTest extends FlatSpec with TestCommon {

  /* TextList tests */
  Spec[TextList] should "extend OPList[String]" in {
    val myTextList = new TextList(List.empty[String])
    myTextList shouldBe a[FeatureType]
    myTextList shouldBe a[OPCollection]
    myTextList shouldBe a[OPList[_]]
  }
  it should "compare values correctly" in {
    new TextList(List("Hello", "Bye")).equals(new TextList(List("Hello", "Bye"))) shouldBe true
    new TextList(List("Bye", "Hello")).equals(new TextList(List("Hello", "Bye"))) shouldBe false
    FeatureTypeDefaults.TextList.equals(new TextList(List("Hello", "Bye"))) shouldBe false
    FeatureTypeDefaults.TextList.equals(TextList(List.empty[String])) shouldBe true

    List("Goodbye", "world").toTextList shouldBe a[TextList]
  }

  /* DateList tests */
  Spec[DateList] should "extend OPList[Long]" in {
    val myDateList = new DateList(List.empty[Long])
    myDateList shouldBe a[FeatureType]
    myDateList shouldBe a[OPCollection]
    myDateList shouldBe a[OPList[_]]
  }
  it should "compare values correctly" in {
    new DateList(List(456L, 13L)).equals(new DateList(List(456L, 13L))) shouldBe true
    new DateList(List(13L, 456L)).equals(new DateList(List(456L, 13L))) shouldBe false
    FeatureTypeDefaults.DateList.equals(new DateList(List(456L, 13L))) shouldBe false
    FeatureTypeDefaults.DateList.equals(DateList(List.empty[Long])) shouldBe true

    List(44829L, 389093L).toDateList shouldBe a[DateList]
  }

  /* DateTimeList tests */
  Spec[DateTimeList] should "extend OPList[Long]" in {
    val myDateTimeList = new DateTimeList(List.empty[Long])
    myDateTimeList shouldBe a[FeatureType]
    myDateTimeList shouldBe a[OPCollection]
    myDateTimeList shouldBe a[OPList[_]]
  }
  it should "compare values correctly" in {
    new DateTimeList(List(456L, 13L)).equals(new DateTimeList(List(456L, 13L))) shouldBe true
    new DateTimeList(List(13L, 456L)).equals(new DateTimeList(List(456L, 13L))) shouldBe false
    FeatureTypeDefaults.DateTimeList.equals(new DateTimeList(List(456L, 13L))) shouldBe false
    FeatureTypeDefaults.DateTimeList.equals(DateTimeList(List.empty[Long])) shouldBe true

    List(12237834L, 4890489839L).toDateTimeList shouldBe a[DateTimeList]
  }


}
