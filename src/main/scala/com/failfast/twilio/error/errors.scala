package com.failfast.twilio.error

case class TwilioError(code: Int, message: String, moreInfo: String, status: Int)

object PredefinedErrors{

  val serverError = TwilioError(0, "Server Unavailable","Server Unavailable", 500)

}
