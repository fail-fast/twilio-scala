package com.failfast.twilio.request

import com.failfast.twilio.http.{PostRequest, HttpMethod}

/**
 * See twilio doc: https://www.twilio.com/docs/api/rest/token#instance
 */
case class CreateTokenRequest() extends TwilioRequest{

  override def httpMethod: HttpMethod = PostRequest

  override def fields: Seq[(String, String)] = Seq()

  override def query: Option[String] = Option.empty
}
