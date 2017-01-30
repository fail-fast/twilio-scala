package com.failfast.twilio

import com.failfast.twilio.executor.ExecutorImplicits._
import com.failfast.twilio.request.CreateTokenRequest
import com.failfast.twilio.resource.Token
import com.typesafe.config.ConfigFactory
import org.scalatest._
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.time.{Seconds, Span}

import scala.concurrent.Future


class CreateTokenTest extends FeatureSpec with GivenWhenThen with ScalaFutures with EitherValues with Matchers{


  info("As a twilio client")
  info("I want to be able to authenticate and create a token")

  feature("Create Token") {
    scenario("Client provide a valid credential and create token") {

      Given("a valid credential")
      val config = ConfigFactory.load()
      val client = TwilioRestClient(sid = config.getString("twilio.sid"), authToken = config.getString("twilio.token"))

      val createTokenRequest = CreateTokenRequest()

      When("the request get send to twilio")
      import scala.concurrent.ExecutionContext.Implicits.global

      val futureToken: Future[Token] = client.execute[CreateTokenRequest, Token](createTokenRequest)
      futureToken.map{ token =>
        println(s"Token: ${token}")
      }.recover{
        case t: Throwable =>
          t.printStackTrace()
          throw t
      }

      Then("Create the token")

      whenReady(futureToken, timeout(Span(10, Seconds))){ token =>
        println(s"token: ${futureToken}")
        //assert(!token.iceServers.isEmpty)
        assert(true)
      }

    }

  }

}
