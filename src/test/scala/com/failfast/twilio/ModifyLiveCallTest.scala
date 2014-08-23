package com.failfast.twilio

import com.failfast.twilio.request.{LiveCallRequest, CallRequest}
import com.failfast.twilio.resource.Call
import com.typesafe.config.ConfigFactory
import org.scalatest._
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.time.{Seconds, Span}
import com.failfast.twilio.executor.ExecutorImplicits._
import scala.concurrent.{duration, Await}
import duration._


class ModifyLiveCallTest extends FeatureSpec with GivenWhenThen with ScalaFutures with EitherValues with Matchers{


  info("As a twilio client")
  info("I want to be able to make a call and redirect it")

  feature("Send a voice message") {
    scenario("Client provide a valid credential and send a voice message and redirect it after some seconds") {

      Given("a valid credential")
      val config = ConfigFactory.load()
      val client = TwilioRestClient(sid = config.getString("twilio.sid"), authToken = config.getString("twilio.token"))

      val request = CallRequest(from = config.getString("twilio.from"), to = config.getString("twilio.to"), url = Option("http://demo.twilio.com/docs/voice.xml"))

      When("the request get send to twilio")

      val futureCall = client.execute[CallRequest, Call](request)

      Then("Call status has to be in progress")

      val call = Await.result(futureCall, 10.seconds)

      Thread.sleep(10000)
      val liveRequest = LiveCallRequest(call.sid, Option("http://twimlets.com/message?Message=Hello"))

      val futureLiveCall = client.execute[LiveCallRequest, Call](liveRequest)

      whenReady(futureLiveCall, timeout(Span(10, Seconds))){ live =>

        assert(live.status == "in-progress")

      }



    }

  }


}
