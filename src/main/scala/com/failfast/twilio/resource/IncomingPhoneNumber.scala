package com.failfast.twilio.resource

import com.failfast.twilio.json.IncomingPhoneNumberJson
import com.failfast.twilio.response.TwilioResponse

case class IncomingPhoneNumber(
                                sid: String,
                                accountSid: String,
                                friendlyName: String,
                                phoneNumber: String,
                                voiceUrl: String,
                                voiceMethod: String,
                                voiceFallbackUrl: Option[String],
                                voiceFallbackMethod: Option[String],
                                voiceCallerIdLookup: Option[Boolean],
                                voiceApplicationSid: Option[String],
                                dateCreated: String,
                                dateUpdated: String,
                                smsUrl: Option[String],
                                smsMethod: Option[String],
                                smsFallbackUrl: Option[String],
                                smsFallbackMethod: Option[String],
                                smsApplicationSid: String,
                                capabilities: Capabilities,
                                statusCallback: Option[String],
                                statusCallback_method: Option[String],
                                apiVersion: String,
                                uri: String

                                ) extends TwilioResponse

object IncomingPhoneNumber{

  def apply(json: IncomingPhoneNumberJson): IncomingPhoneNumber =
  IncomingPhoneNumber(
    json.sid,
    json.account_sid,
    json.friendly_name,
    json.phone_number,
    json.voice_url,
    json.voice_method,
    json.voice_fallback_url,
    json.voice_fallback_method,
    json.voice_caller_id_lookup,
    json.voice_application_sid,
    json.date_created,
    json.date_updated,
    json.sms_url,
    json.sms_method,
    json.sms_fallback_url,
    json.sms_fallback_method,
    json.sms_application_sid,
    json.capabilities,
    json.status_callback,
    json.status_callback_method,
    json.api_version,
    json.uri

  )

}