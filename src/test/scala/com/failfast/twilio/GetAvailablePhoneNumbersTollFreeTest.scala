package com.failfast.twilio

import com.failfast.twilio.request.AvailablePhoneNumbersTollFreeRequest
import com.failfast.twilio.resource.AvailablePhoneNumbers
import com.typesafe.config.ConfigFactory
import org.scalatest._
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.time.{Span, Seconds}
import com.failfast.twilio.executor.ExecutorImplicits._

class GetAvailablePhoneNumbersTollFreeTest extends FeatureSpec with GivenWhenThen with ScalaFutures with EitherValues with Matchers{


  info("As a twilio client")
  info("I want to be able to get available phone numbers")

  feature("Get Available Toll Free phone numbers") {
    scenario("Client provide a valid credential and retrieve available phone numbers") {

      Given("a valid credential")
      val config = ConfigFactory.load()
      val client = TwilioRestClient(sid = config.getString("twilio.sid"), authToken = config.getString("twilio.token"))

      val request = AvailablePhoneNumbersTollFreeRequest(isoCountryCode = "US", areaCode = Some("855"))

      When("the request get send to twilio")

      val futureNumbers = client.execute[AvailablePhoneNumbersTollFreeRequest, AvailablePhoneNumbers](request)

      Then("Get Available phone numbers")

      whenReady(futureNumbers, timeout(Span(10, Seconds))){ numbers =>
        assert(numbers.availablePhoneNumbers.length > 0)

      }

    }

  }


}
