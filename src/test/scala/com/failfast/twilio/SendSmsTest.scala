package com.failfast.twilio

import com.failfast.twilio.request.SmsRequest
import com.failfast.twilio.resource.Message
import com.typesafe.config.ConfigFactory
import org.scalatest._
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.time.{Seconds, Span}
import com.failfast.twilio.executor.ExecutorImplicits._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

class SendSmsTest extends FeatureSpec with GivenWhenThen with ScalaFutures with EitherValues with Matchers{


  info("As a twilio client")
  info("I want to be able to send a SMS")

  feature("Send SMS") {
    scenario("Client provide a valid credential and send a SMS message") {

      Given("a valid credential and SMS message information")
      val config = ConfigFactory.load()
      val client = TwilioRestClient(sid = config.getString("twilio.sid"), authToken = config.getString("twilio.token"))

      val request = SmsRequest(from = config.getString("twilio.from"), to = config.getString("twilio.to"), body = Option("what's up?"))

      When("the request get sent to twilio")

      val fResponse = client.execute[SmsRequest, Message](request)

      Then("Get Message response")

      whenReady(fResponse, timeout(Span(10, Seconds))){ message =>

        assert(message.accountSid == config.getString("twilio.sid"))

      }

    }

  }

}
