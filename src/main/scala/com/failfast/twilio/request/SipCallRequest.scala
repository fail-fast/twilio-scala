package com.failfast.twilio.request

import com.failfast.twilio.http.{PostRequest, HttpMethod}


/**
 * See twilio doc: https://www.twilio.com/docs/api/rest/making-calls-sip
 */
case class SipCallRequest(to: String,
                       from: Option[String] = None,
                       url: Option[String] = None,
                       sipAuthUsername: Option[String] = None,
                       sipAuthPassword: Option[String] = None) extends TwilioRequest{

  override def httpMethod: HttpMethod = PostRequest


  override def fields: Seq[(String, String)] = {

    def add (param: String, value: Option[String])(fs: Seq[(String, String)]): Seq[(String, String)] = {
      value.map(v => fs.+:(param -> v)).getOrElse(fs)
    }

    val funcs = add ("From", from) _ andThen add("SipAuthUsername", sipAuthUsername) andThen add("Url", url) andThen add("SipAuthPassword", sipAuthPassword)
    funcs(Seq("To" -> to))

  }

  override def query: Option[String] = Option.empty
}
