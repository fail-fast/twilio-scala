package com.failfast.twilio

import com.failfast.twilio.executor.ExecutorImplicits._
import com.failfast.twilio.request.{AccountsRequest}
import com.failfast.twilio.resource.{Accounts}
import com.typesafe.config.ConfigFactory
import org.scalatest._
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.time.{Seconds, Span}


class GetAccountsTest extends FeatureSpec with GivenWhenThen with ScalaFutures with EitherValues with Matchers{


  info("As a twilio client")
  info("I want to be able to authenticate and get all accounts info")

  feature("Get All Accounts Info") {
    scenario("Client provide a valid credential and retrieve all accounts info") {

      Given("a valid credential")
      val config = ConfigFactory.load()
      val client = TwilioRestClient(sid = config.getString("twilio.sid"), authToken = config.getString("twilio.token"))

      val request = AccountsRequest(status = Option("active"), page = Option(0), pageSize = Option(5))

      When("the request get send to twilio")

      val futureAccounts = client.execute[AccountsRequest, Accounts](request)

      Then("Get accounts information")

      whenReady(futureAccounts, timeout(Span(10, Seconds))){ accounts =>
        assert(accounts.accounts.length == 1)
      }

    }

  }


}
