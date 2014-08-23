package com.failfast.twilio.request

import com.failfast.twilio.http.{GetRequest, HttpMethod}

/**
 * See twilio doc: https://www.twilio.com/docs/api/rest/account#instance
 */
case class AccountRequest() extends TwilioRequest{

  override def httpMethod: HttpMethod = GetRequest

  override def fields: Seq[(String, String)] = Seq()

  override def query: Option[String] = Option.empty
}
