package com.failfast.twilio.request

import com.failfast.twilio.http.{GetRequest, HttpMethod}


/**
 * See twilio doc: https://www.twilio.com/docs/api/rest/available-phone-numbers#local-instance
 */
case class AvailablePhoneNumbersLocalRequest(isoCountryCode: String,
                                             areaCode: Option[String] = None,
                                             contains: Option[String] = None,
                                             smsEnabled: Option[String] = None,
                                             mmsEnabled: Option[String] = None,
                                             voiceEnabled: Option[String] = None,
                                             nearNumber: Option[String] = None,
                                             nearLatLong: Option[String] = None,
                                             distance: Option[String] = None,
                                             inPostalCode: Option[String] = None,
                                             inRegion: Option[String] = None,
                                             inRateCenter: Option[String] = None,
                                             inLata: Option[String] = None
                                         ) extends TwilioRequest {



  override def httpMethod: HttpMethod = GetRequest

  override def fields: Seq[(String, String)] = Seq()

  override def query: Option[String] = {

    (concat(buildQuery("AreaCode", areaCode), _: Option[String]))
      .andThen(concat(buildQuery("Contains", contains), _: Option[String]))
      .andThen(concat(buildQuery("SmsEnabled", smsEnabled), _: Option[String]))
      .andThen(concat(buildQuery("MmsEnabled", mmsEnabled), _: Option[String]))
      .andThen(concat(buildQuery("NearLatLong", nearLatLong), _: Option[String]))
      .andThen(concat(buildQuery("Distance", distance), _: Option[String]))
      .andThen(concat(buildQuery("InPostalCode", inPostalCode), _: Option[String]))
      .andThen(concat(buildQuery("InRegion", inRegion), _: Option[String]))
      .andThen(concat(buildQuery("InRateCenter", inRateCenter), _: Option[String]))
      .andThen(concat(buildQuery("InLata", inLata), _: Option[String]))
    concat(buildQuery("VoiceEnabled", voiceEnabled), buildQuery("NearNumber", nearNumber)) map (v => s"?$v")
  }

}
