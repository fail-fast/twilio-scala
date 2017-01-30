package com.failfast.twilio.json

import com.failfast.twilio.resource.{CapabilitiesAvailableNumbers, SubResourceUris, Capabilities}
import spray.json.DefaultJsonProtocol._
import spray.json._

trait DefaultJsonFormats {

  implicit val errorJson = jsonFormat4(TwilioErrorJson)
  implicit val jsonFormatAccSubResource = jsonFormat10(AccountSubResourceJson)
  implicit val jsonFormatAcc = jsonFormat10(AccountJson)
  implicit val jsonFormatAccs = jsonFormat12(AccountsJson)
  implicit val jsonFormatTokenJson = jsonFormat7(TokenJson)
  implicit val jsonFormatSubResourceUris = jsonFormat1(SubResourceUrisJson)
  implicit val jsonFormatMessage = jsonFormat18(MessageJson)
  implicit val jsonFormatAvailableCapabilities = jsonFormat3(Capabilities)
  implicit val jsonFormatAvailableCapabilitiesAvailableNumbers = jsonFormat3(CapabilitiesAvailableNumbers)
  implicit val jsonFormatAvailablePhoneNumber = jsonFormat9(AvailablePhoneNumberJson)
  implicit val jsonFormatAvailablePhoneNumbers = jsonFormat2(AvailablePhoneNumbersJson)
  implicit val jsonFormatSubResourcesUri = jsonFormat2(SubResourceUris)
  implicit val jsonFormatCall = jsonFormat21(CallJson)
  implicit val jsonFormatIncomingPhoneNumberJson = jsonFormat22(IncomingPhoneNumberJson)
  implicit val jsonFormatIncomingPhoneNumbersJson = jsonFormat12(IncomingPhoneNumbersJson)


}
