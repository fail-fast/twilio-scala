package com.failfast.twilio.exception

import com.failfast.twilio.error.TwilioError

case class TwilioException(error: TwilioError, originalException: Option[Throwable] = None) extends RuntimeException {

}
