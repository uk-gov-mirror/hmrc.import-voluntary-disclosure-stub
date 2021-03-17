/*
 * Copyright 2021 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package controllers

import java.time.Instant

import javax.inject.{Inject, Singleton}
import play.api.Logger
import play.api.libs.json.Json
import play.api.mvc.{Action, AnyContent, ControllerComponents}
import uk.gov.hmrc.play.bootstrap.backend.controller.BackendController

import scala.concurrent.Future

@Singleton
class AddressLookUpController @Inject()(cc: ControllerComponents)
  extends BackendController(cc) {

  def getAddress(id: Option[String]): Action[AnyContent] =  Action.async { implicit request =>

    val successBody = s"""{
         |"address": {
         |  "lines": [
         |    "64 South Audley Street",
         |    "Mayfair",
         |    "London"
         |    ],
         |      "postcode": "W1K 2QT",
         |      "country": {
         |        "code": "GB",
         |        "name": "United Kingdom"
         |      }
         |    }
         |}
         |""".stripMargin

    Future.successful(Ok(successBody))
  }

}
