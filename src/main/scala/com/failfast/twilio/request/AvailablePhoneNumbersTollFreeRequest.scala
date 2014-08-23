package com.failfast.twilio.request

import com.failfast.twilio.http.{GetRequest, HttpMethod}

/**
 * See twilio doc: https://www.twilio.com/docs/api/rest/available-phone-numbers#toll-free-instance
 */
case class AvailablePhoneNumbersTollFreeRequest(isoCountryCode: String, areaCode: Option[String] = None, contains: Option[String] = None) extends TwilioRequest{

  override def httpMethod: HttpMethod = GetRequest

  override def fields: Seq[(String, String)] = Seq()

  override def query: Option[String] = {
    concat(buildQuery("AreaCode", areaCode), buildQuery("Contains", contains)) map (v => s"?$v")
  }

}
