package com.failfast.twilio.request

import com.failfast.twilio.http.{PostRequest, HttpMethod}


/**
 * See twilio doc: https://www.twilio.com/docs/api/rest/change-call-state
 */
case class LiveCallRequest(callSid: String,
                       url: Option[String] = None,
                       method: Option[String] = None,
                       status: Option[String] = None,
                       fallbackUrl: Option[String] = None,
                       fallbackMethod: Option[String] = None,
                       statusCallback: Option[String] = None,
                       statusCallbackMethod: Option[String] = None
                       ) extends TwilioRequest{

  override def httpMethod: HttpMethod = PostRequest


  override def fields: Seq[(String, String)] = {

    def add (param: String, value: Option[String])(fs: Seq[(String, String)]): Seq[(String, String)] = {
      value.map(v => fs.+:(param -> v)).getOrElse(fs)
    }

    val funcs = add("Url", url) _ andThen add("Method", method) andThen add("Status", status) andThen add("FallbackUrl", fallbackUrl) andThen add("FallbackMethod", fallbackMethod) andThen add("StatusCallback", statusCallback) andThen add("StatusCallbackMethod", statusCallbackMethod)
    funcs(Seq())

  }

  override def query: Option[String] = Option.empty
}
