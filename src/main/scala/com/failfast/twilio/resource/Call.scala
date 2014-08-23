package com.failfast.twilio.resource

import com.failfast.twilio.json.CallJson
import com.failfast.twilio.response.TwilioResponse

case class Call(
               sid: String,
               dateCreated: Option[String],
               dateUpdated: Option[String],
               parentCallSid: Option[String],
               accountSid: String,
               to: String,
               toFormatted: String,
               from: String,
               fromFormatted: String,
               phoneNumberSid: Option[String],
               status: String,
               startTime: Option[String],
               endTime: Option[String],
               duration: Option[String],
               price: Option[String],
//               priceUnit: String,
               direction: String,
               answeredBy: Option[String],
//               apiVersion: String,
//               annotation: Option[String],
               forwardedFrom: Option[String],
//               groupSid: Option[String],
               callerName: Option[String],
               uri: String,
               subresourceUris: SubResourceUris) extends TwilioResponse

object Call{

  def apply(json: CallJson): Call = {
    Call(
      json.sid,
      json.date_created,
      json.date_updated,
      json.parent_call_sid,
      json.account_sid,
      json.to,
      json.to_formatted,
      json.from,
      json.from_formatted,
      json.phone_number_sid,
      json.status,
      json.start_time,
      json.end_time,
      json.duration,
      json.price,
//      json.price_unit,
      json.direction,
      json.answered_by,
//      json.api_version,
//      json.annotation,
      json.forwarded_from,
//      json.group_sid,
      json.caller_name,
      json.uri,
      json.subresource_uris
    )
  }

}