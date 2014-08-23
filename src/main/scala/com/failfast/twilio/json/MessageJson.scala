package com.failfast.twilio.json

import com.failfast.twilio.response.TwilioResponse

case class MessageJson(account_sid: String,
  api_version: String,
  body: String,
  num_segments: String,
  num_media: String,
  date_created: String,
  date_sent: Option[String],
  date_updated: String,
  direction: String,
  error_code: Option[String],
  error_message: Option[String],
  from: Option[String],
  price: Option[String],
  sid: String,
  status: String,
  to: String,
  uri: String,
  subresource_uris: SubResourceUrisJson) extends TwilioResponse

case class SubResourceUrisJson(media: String)

