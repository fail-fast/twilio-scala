package com.failfast.twilio


import com.failfast.twilio.executor.OperationExecutor
import com.failfast.twilio.request.TwilioRequest
import com.failfast.twilio.response.TwilioResponse

import scala.concurrent.Future

object TwilioRestClient {

  def apply(sid: String, authToken: String) = new TwilioRestClient(Credential(sid, authToken))
}


class TwilioRestClient(credential: Credential) {

  def execute[A <: TwilioRequest, B <: TwilioResponse] (request: A) (implicit executor: OperationExecutor[A, B]): Future[B] = {
    executor.execute(request) (credential)
  }


}
