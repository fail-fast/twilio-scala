package com.failfast.twilio.resource

import com.failfast.twilio.json.MessageJson
import com.failfast.twilio.response.TwilioResponse

case class Message(accountSid: String,
                    apiVersion: String,
                    body: String,
                    numSegments: String,
                    numMedia: String,
                    dateCreated: String,
                    dateSent: Option[String],
                    dateUpdated: String,
                    direction: String,
                    errorCode: Option[String],
                    errorMessage: Option[String],
                    from: Option[String],
                    price: Option[String],
                    sid: String,
                    status: String,
                    to: String,
                    uri: String) extends TwilioResponse

object Message{

  def apply(json: MessageJson): Message =  Message(
    json.account_sid,
    json.api_version,
    json.body,
    json.num_segments,
    json.num_media,
    json.date_created,
    json.date_sent,
    json.date_updated,
    json.direction,
    json.error_code,
    json.error_message,
    json.from,
    json.price,
    json.sid,
    json.status,
    json.to,
    json.uri )
}


