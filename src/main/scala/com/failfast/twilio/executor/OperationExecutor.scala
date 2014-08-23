package com.failfast.twilio.executor

import akka.actor.ActorSystem
import akka.util.Timeout
import com.failfast.twilio.http.{PutRequest, DeleteRequest, GetRequest}
import spray.can.Http

import akka.pattern.ask
import akka.io.IO
import com.failfast.twilio.{Credential, TwilioConfig}
import com.failfast.twilio.request.TwilioRequest
import com.failfast.twilio.response.TwilioResponse
import spray.http._
import spray.json.{DefaultJsonProtocol}
import spray.util._
import spray.client.pipelining._
import scala.concurrent.{duration, Future}
import duration._
import scala.concurrent.{Future}

trait OperationExecutor[A <: TwilioRequest, B <: TwilioResponse] extends TwilioConfig with DefaultJsonProtocol{

  //FIXME hast to go to con
  implicit val system = ActorSystem("twilio-scala")
  import system.dispatcher
  implicit val timeout = Timeout(10.seconds)

  val pipeline: Future[SendReceive] =
    for (
      Http.HostConnectorInfo(connector, _) <-
      IO(Http) ? Http.HostConnectorSetup(endpoint, port = 443, sslEncryption = true)
    ) yield sendReceive(connector)

  val headers: (Credential) => RequestTransformer = { credential =>
    addHeader("X-Twilio-Client", s"scala-$version") ~>
    addHeader("User-Agent", s"twilio-scala-$version") ~>
    addHeader("Accept-Charset", "utf-8") ~>
    addCredentials(BasicHttpCredentials(credential.sid, credential.authToken))
  }

  /**
   *
   * @param request
   * @param credential
   * @return
   */
  def execute(request: A) (credential: Credential) : Future[B]


  /**
   *
   * @param request
   * @param credential
   * @param locator
   * @return
   */
  def performRequest(request: A, credential: Credential) (implicit locator: (A, Credential) => Endpoint) : HttpRequest = {
    val endpoint = locator(request, credential)
    val url = request.query.map(query => s"/$TWILIO_DEFAULT_VERSION${endpoint.url}$query").getOrElse(s"/$TWILIO_DEFAULT_VERSION${endpoint.url}")

    request.httpMethod match{
      case GetRequest => Get(url) ~> headers(credential)
      case DeleteRequest => Delete(url) ~> headers(credential)
      case PutRequest => Put(url, FormData(request.fields)) ~> headers(credential)
      case _ => Post(url, FormData(request.fields)) ~> headers(credential)
    }



  }

}
