package com.failfast.twilio.request


import com.failfast.twilio.http.{PostRequest, HttpMethod}

/**
 * See twilio doc: https://www.twilio.com/docs/api/rest/sending-messages
 */
case class SmsRequest(from: String, to: String, body: Option[String] = None, mediaUrl: Option[String] = None, statusCallBack: Option[String] = None) extends TwilioRequest{

  override def httpMethod: HttpMethod = PostRequest

  override def fields: Seq[(String, String)] =
    Seq(
      Option("From" -> from),
      Option("To" -> to),
      body.map(x => "Body" -> x),
      mediaUrl.map(x => "MediaUrl" -> x),
      statusCallBack.map(x => "StatusCallback" -> x)
    ).flatMap(x => x)

  override def query: Option[String] = Option.empty
}
