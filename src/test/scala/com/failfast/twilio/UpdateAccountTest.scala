package com.failfast.twilio

import com.failfast.twilio.executor.ExecutorImplicits._
import com.failfast.twilio.request.UpdateAccountRequest
import com.failfast.twilio.resource.Account
import com.typesafe.config.ConfigFactory
import org.scalatest._
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.time.{Seconds, Span}


class UpdateAccountTest extends FeatureSpec with GivenWhenThen with ScalaFutures with EitherValues with Matchers{


  info("As a twilio client")
  info("I want to be able to authenticate and update my account info")

  feature("Update Account Info") {
    scenario("Client provide a valid credential and update the friendly name") {

      Given("a valid credential and a new friendly name")
      val config = ConfigFactory.load()
      val client = TwilioRestClient(sid = config.getString("twilio.sid"), authToken = config.getString("twilio.token"))

      val getAccountRequest = UpdateAccountRequest(friendlyName = Option("my friendly Name"))

      When("the request get sent to twilio")

      val futureAccountInfo = client.execute[UpdateAccountRequest, Account](getAccountRequest)

      Then("Get the account information")

      whenReady(futureAccountInfo, timeout(Span(10, Seconds))){ account =>
        assert(account.sid == config.getString("twilio.sid"))
        assert(account.friendlyName == "my friendly Name")
      }

    }

  }

}
