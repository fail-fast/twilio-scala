package com.failfast.twilio.json

import com.failfast.twilio.resource.SubResourceUris

case class CallJson(
                     sid: String,
                     date_created: Option[String],
                     date_updated: Option[String],
                     parent_call_sid: Option[String],
                     account_sid: String,
                     to: String,
                     to_formatted: String,
                     from: String,
                     from_formatted: String,
                     phone_number_sid: Option[String],
                     status: String,
                     start_time: Option[String],
                     end_time: Option[String],
                     duration: Option[String],
                     price: Option[String],
                     direction: String,
                     answered_by: Option[String],
                     forwarded_from: Option[String],
                     caller_name: Option[String],
                     uri: String,
                     subresource_uris: SubResourceUris)
