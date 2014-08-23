package com.failfast.twilio

import com.failfast.twilio.executor.ExecutorImplicits._
import com.failfast.twilio.request.AccountRequest
import com.failfast.twilio.resource.Account
import com.typesafe.config.{ConfigFactory}
import org.scalatest._
import org.scalatest.concurrent.{ScalaFutures}
import org.scalatest.time.{Span, Seconds}


class GetAccountTest extends FeatureSpec with GivenWhenThen with ScalaFutures with EitherValues with Matchers{


  info("As a twilio client")
  info("I want to be able to authenticate and get my account info")

  feature("Get Account Info") {
    scenario("Client provide a valid credential and retrieve account info") {

      Given("a valid credential")
      val config = ConfigFactory.load()
      val client = TwilioRestClient(sid = config.getString("twilio.sid"), authToken = config.getString("twilio.token"))

      val getAccountRequest = AccountRequest()

      When("the request get send to twilio")

      val futureAccountInfo = client.execute[AccountRequest, Account](getAccountRequest)

      Then("Get the account information")

      whenReady(futureAccountInfo, timeout(Span(10, Seconds))){ account =>
        assert(account.sid == config.getString("twilio.sid"))

      }

    }

  }

}
