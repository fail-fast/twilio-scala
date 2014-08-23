package com.failfast.twilio.request


import com.failfast.twilio.http.{PostRequest, HttpMethod}

/**
 * See twilio doc: https://www.twilio.com/docs/api/rest/call
 */
case class CallRequest(from: String,
                       to: String,
                       url: Option[String] = None,
                       applicationSid: Option[String] = None,
                       method: Option[String] = None,
                       fallbackUrl: Option[String] = None,
                       fallbackMethod: Option[String] = None,
                       statusCallback: Option[String] = None,
                       statusCallbackMethod: Option[String] = None,
                       sendDigits: Option[String] = None,
                       ifMachine: Option[String] = None,
                       timeout: Option[String] = None,
                       record: Option[String] = None) extends TwilioRequest{

  override def httpMethod: HttpMethod = PostRequest


  override def fields: Seq[(String, String)] = {

    def add (param: String, value: Option[String])(fs: Seq[(String, String)]): Seq[(String, String)] = {
      value.map(v => fs.+:(param -> v)).getOrElse(fs)
    }

    val funcs = add ("Url", url) _ andThen add("ApplicationSid", applicationSid) andThen add("Method", method) andThen add("FallbackUrl", fallbackUrl) andThen add("FallbackMethod", fallbackMethod) andThen add("StatusCallback", statusCallback) andThen add("StatusCallbackMethod", statusCallbackMethod) andThen add("SendDigits", sendDigits) andThen add("IfMachine", ifMachine) andThen add("Timeout", timeout) andThen add("Record", record)
    funcs(Seq("From" -> from, "To" -> to))

  }

  override def query: Option[String] = Option.empty
}
