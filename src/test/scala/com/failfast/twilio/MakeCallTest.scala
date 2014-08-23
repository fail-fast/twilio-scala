package com.failfast.twilio

import com.failfast.twilio.exception.TwilioException
import com.failfast.twilio.request.CallRequest
import com.failfast.twilio.resource.Call
import com.typesafe.config.ConfigFactory
import org.scalatest._
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.time.{Seconds, Span}
import com.failfast.twilio.executor.ExecutorImplicits._
import scala.concurrent.ExecutionContext.Implicits.global


class MakeCallTest extends FeatureSpec with GivenWhenThen with ScalaFutures with EitherValues with Matchers{


  info("As a twilio client")
  info("I want to be able to make a call")

  feature("Send a voice message") {
    scenario("Client provide a valid credential and send a voice message") {

      Given("a valid credential")
      val config = ConfigFactory.load()
      val client = TwilioRestClient(sid = config.getString("twilio.sid"), authToken = config.getString("twilio.token"))

      val request = CallRequest(from = config.getString("twilio.from"), to = config.getString("twilio.to"), url = Option("http://twimlets.com/message?Message=Hello"))

      When("the request get send to twilio")

      val futureNumbers = client.execute[CallRequest, Call](request)

      futureNumbers.onFailure{ case e: TwilioException => println(e.error)}

      Then("Call must have a valid call ID")

      whenReady(futureNumbers, timeout(Span(10, Seconds))){ call =>

        assert(call.sid.nonEmpty)

      }

    }

  }


}
