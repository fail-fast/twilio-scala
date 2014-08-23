package com.failfast.twilio.request

import com.failfast.twilio.http.{GetRequest, HttpMethod}


/**
 * See twilio doc: https://www.twilio.com/docs/api/rest/available-phone-numbers#mobile-instance
 */
case class AvailablePhoneNumbersMobileRequest(isoCountryCode: String, contains: Option[String] = None, smsEnabled: Option[String] = None, mmsEnabled: Option[String] = None, voiceEnabled: Option[String] = None
                                         ) extends TwilioRequest{
  override def httpMethod: HttpMethod = GetRequest

  override def fields: Seq[(String, String)] = Seq()

  override def query: Option[String] = {

    (concat(buildQuery("Contains", contains), _: Option[String]))
      .andThen(concat(buildQuery("SmsEnabled", smsEnabled), _: Option[String]))
    concat(buildQuery("MmsEnabled", mmsEnabled), buildQuery("VoiceEnabled", voiceEnabled)) map (v => s"?$v")
  }

}
