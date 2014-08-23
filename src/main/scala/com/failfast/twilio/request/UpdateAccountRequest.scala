package com.failfast.twilio.request

import com.failfast.twilio.http.{HttpMethod, PostRequest}


/**
 * See twilio doc: https://www.twilio.com/docs/api/rest/account#instance-post
 */
case class UpdateAccountRequest(friendlyName: Option[String] = None, status: Option[String] = None) extends TwilioRequest{

  override def httpMethod: HttpMethod = PostRequest

  override def fields: Seq[(String, String)] = Seq("FriendlyName" -> friendlyName.get)

  override def query: Option[String] = Option.empty
}
