package com.failfast.twilio.json

import com.failfast.twilio.resource.Capabilities

case class IncomingPhoneNumberJson(
                                    sid: String,
                                    account_sid: String,
                                    friendly_name: String,
                                    phone_number: String,
                                    voice_url: String,
                                    voice_method: String,
                                    voice_fallback_url: Option[String],
                                    voice_fallback_method: Option[String],
                                    voice_caller_id_lookup: Option[Boolean],
                                    voice_application_sid: Option[String],
                                    date_created: String,
                                    date_updated: String,
                                    sms_url: Option[String],
                                    sms_method: Option[String],
                                    sms_fallback_url: Option[String],
                                    sms_fallback_method: Option[String],
                                    sms_application_sid: String,
                                    capabilities: Capabilities,
                                    status_callback: Option[String],
                                    status_callback_method: Option[String],
                                    api_version: String,
                                    uri: String )
