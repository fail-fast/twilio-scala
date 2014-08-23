package com.failfast.twilio.request

import com.failfast.twilio.http.{GetRequest, HttpMethod}
import com.failfast.twilio.resource.PhoneNumberType


/**
 * See twilio doc: https://www.twilio.com/docs/api/rest/incoming-phone-numbers
 */
case class IncomingPhoneNumbersRequest(phoneNumberType: Option[PhoneNumberType] = None, phoneNumber: Option[String] = None, friendlyName: Option[String] = None) extends TwilioRequest{

  override def httpMethod: HttpMethod = GetRequest

  override def fields: Seq[(String, String)] = Seq()

  override def query: Option[String] =
    concat(buildQuery("FriendlyName", friendlyName),buildQuery("PhoneNumber", phoneNumber)) map (v => s"?$v")
}
