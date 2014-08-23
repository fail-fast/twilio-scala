package com.failfast.twilio

import com.failfast.twilio.exception.TwilioException
import com.failfast.twilio.request.{IncomingPhoneNumberRequest, IncomingPhoneNumbersRequest, AvailablePhoneNumbersTollFreeRequest, AvailablePhoneNumbersMobileRequest}
import com.failfast.twilio.resource.{Local, IncomingPhoneNumbers, IncomingPhoneNumber, AvailablePhoneNumbers}
import com.typesafe.config.ConfigFactory
import org.scalatest._
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.time.{Span, Seconds}
import com.failfast.twilio.executor.ExecutorImplicits._
import scala.concurrent.ExecutionContext.Implicits.global


class GetIncomingPhoneNumbersTest extends FeatureSpec with GivenWhenThen with ScalaFutures with EitherValues with Matchers{


  info("As a twilio client")
  info("I want to be able to get incoming phone numbers")

  feature("Get incoming phone number") {
    scenario("Client provide a valid credential and retrieve incoming phone number") {

      Given("a valid credential")
      val config = ConfigFactory.load()
      val client = TwilioRestClient(sid = config.getString("twilio.sid"), authToken = config.getString("twilio.token"))

      val request = IncomingPhoneNumberRequest(incomingPhoneNumber = "PNe31456d36877705997460ca3d9526e94")

      When("the request get send to twilio")

      val futureNumbers = client.execute[IncomingPhoneNumberRequest, IncomingPhoneNumber](request)
      futureNumbers.onFailure{ case e: TwilioException => println(e.error); e.originalException.get.printStackTrace()}
      Then("Get incoming phone numbers")

      whenReady(futureNumbers, timeout(Span(10, Seconds))){ number =>
        println(s"Number ->> $number")

        assert(number.sid == "PNe31456d36877705997460ca3d9526e94")

      }

    }

  }

  feature("Get incoming phone numbers") {
    scenario("Client provide a valid credential and retrieve incoming phone numbers") {

      Given("a valid credential")
      val config = ConfigFactory.load()
      val client = TwilioRestClient(sid = config.getString("twilio.sid"), authToken = config.getString("twilio.token"))

      val request = IncomingPhoneNumbersRequest()

      When("the request get send to twilio")

      val futureNumbers = client.execute[IncomingPhoneNumbersRequest, IncomingPhoneNumbers](request)
      futureNumbers.onFailure{ case e: TwilioException => println(e.error); e.originalException.get.printStackTrace()}
      Then("Get incoming phone numbers")

      whenReady(futureNumbers, timeout(Span(10, Seconds))){ numbers =>

        println(s"Numbers ->> $numbers")
        assert(numbers.incomingPhoneNumbers.length > 0)

      }

    }

  }

  feature("Get incoming local phone numbers") {
    scenario("Client provide a valid credential and retrieve incoming local phone numbers") {

      Given("a valid credential")
      val config = ConfigFactory.load()
      val client = TwilioRestClient(sid = config.getString("twilio.sid"), authToken = config.getString("twilio.token"))

      val request = IncomingPhoneNumbersRequest(phoneNumberType = Option(Local))

      When("the request get send to twilio")

      val futureNumbers = client.execute[IncomingPhoneNumbersRequest, IncomingPhoneNumbers](request)
      futureNumbers.onFailure{ case e: TwilioException => println(e.error); e.originalException.get.printStackTrace()}
      Then("Get incoming phone numbers")

      whenReady(futureNumbers, timeout(Span(10, Seconds))){ numbers =>

        println(s"Numbers ->> $numbers")
        assert(numbers.incomingPhoneNumbers.length > 0)

      }

    }

  }

}
