package com.failfast.twilio.executor

import com.failfast.twilio.Credential
import com.failfast.twilio.error.{PredefinedErrors, TwilioError}
import com.failfast.twilio.exception.TwilioException
import com.failfast.twilio.request._
import com.failfast.twilio.json._
import com.failfast.twilio.resource._
import com.typesafe.scalalogging.slf4j.Logging
import scala.concurrent._
import spray.httpx.unmarshalling._
import spray.util._
import spray.http._
import scala.concurrent.ExecutionContext.Implicits.global
import Endpoints._
import spray.json._
import DefaultJsonProtocol._
import spray.httpx.SprayJsonSupport._
import spray.client.pipelining._


object ExecutorImplicits extends Logging with DefaultJsonFormats{

  val checkExceptions: (Throwable) => TwilioException = {
    case e: spray.httpx.UnsuccessfulResponseException =>
      val error = e.response.entity.as[TwilioErrorJson].right.get
      TwilioException(TwilioError(error.code, error.message, error.more_info, error.status))
    case e: Throwable => TwilioException(PredefinedErrors.serverError, Option(e))
  }


  implicit object GetAccountExecutor extends OperationExecutor[AccountRequest, Account]{

    def execute(request: AccountRequest) (credential: Credential): Future[Account] = {

      val fResponse = pipeline.map( p => p ~> unmarshal[AccountJson])

      fResponse.flatMap(_(performRequest(request, credential))).transform[Account](
        { Account(_) }, {checkExceptions}
      )

    }

  }



  implicit object GetAccountsExecutor extends OperationExecutor[AccountsRequest, Accounts]{

    def execute(request: AccountsRequest) (credential: Credential): Future[Accounts] = {

      val fResponse = pipeline.map( p => p ~> unmarshal[AccountsJson])

      fResponse.flatMap(_(performRequest(request, credential))).transform[Accounts](
        { Accounts(_) }, {checkExceptions}
      )

    }

  }

  implicit object UpdateAccountsExecutor extends OperationExecutor[UpdateAccountRequest, Account]{

    def execute(request: UpdateAccountRequest) (credential: Credential): Future[Account] = {

      val fResponse = pipeline.map( p => p ~> unmarshal[AccountJson])

      fResponse.flatMap(_(performRequest(request, credential))).transform[Account](
        { Account(_) },{checkExceptions}
      )

    }

  }

  implicit object SmsExecutor extends OperationExecutor[SmsRequest, Message]{

    def execute(request: SmsRequest) (credential: Credential): Future[Message] = {

      val fResponse = pipeline.map( p => p ~> unmarshal[MessageJson])

      fResponse.flatMap(_(performRequest(request, credential))).transform[Message](
        { Message(_) },{checkExceptions}
      )

    }

  }

  implicit object AvailablePhoneNumbersLocalExecutor extends OperationExecutor[AvailablePhoneNumbersLocalRequest, AvailablePhoneNumbers]{

    def execute(request: AvailablePhoneNumbersLocalRequest) (credential: Credential): Future[AvailablePhoneNumbers] = {

      val fResponse = pipeline.map( p => p ~> unmarshal[AvailablePhoneNumbersJson])

      fResponse.flatMap(_(performRequest(request, credential))).transform[AvailablePhoneNumbers](
        { AvailablePhoneNumbers(_) },{checkExceptions}
      )

    }

  }

  implicit object AvailablePhoneNumbersMobileExecutor extends OperationExecutor[AvailablePhoneNumbersMobileRequest, AvailablePhoneNumbers]{

    def execute(request: AvailablePhoneNumbersMobileRequest) (credential: Credential): Future[AvailablePhoneNumbers] = {

      val fResponse = pipeline.map( p => p ~> unmarshal[AvailablePhoneNumbersJson])

      fResponse.flatMap(_(performRequest(request, credential))).transform[AvailablePhoneNumbers](
        { AvailablePhoneNumbers(_) },{checkExceptions}
      )

    }

  }

  implicit object AvailablePhoneNumbersTollFreeExecutor extends OperationExecutor[AvailablePhoneNumbersTollFreeRequest, AvailablePhoneNumbers]{

    def execute(request: AvailablePhoneNumbersTollFreeRequest) (credential: Credential): Future[AvailablePhoneNumbers] = {

      val fResponse = pipeline.map( p => p ~> unmarshal[AvailablePhoneNumbersJson])

      fResponse.flatMap(_(performRequest(request, credential))).transform[AvailablePhoneNumbers](
        { AvailablePhoneNumbers(_) },{checkExceptions}
      )

    }

  }

  implicit object CallExecutor extends OperationExecutor[CallRequest, Call]{

    def execute(request: CallRequest) (credential: Credential): Future[Call] = {

      val fResponse = pipeline.map( p => p ~> unmarshal[CallJson])

      fResponse.flatMap(_(performRequest(request, credential))).transform[Call](
        { Call(_) },{checkExceptions}
      )

    }

  }

  implicit object LiveCallExecutor extends OperationExecutor[LiveCallRequest, Call]{

    def execute(request: LiveCallRequest) (credential: Credential): Future[Call] = {

      val fResponse = pipeline.map( p => p ~> unmarshal[CallJson])

      fResponse.flatMap(_(performRequest(request, credential))).transform[Call](
        { Call(_) },{checkExceptions}
      )

    }

  }


  implicit object SipCallExecutor extends OperationExecutor[SipCallRequest, Call]{

    def execute(request: SipCallRequest) (credential: Credential): Future[Call] = {
      val fResponse = pipeline.map( p => p ~> unmarshal[CallJson])
      fResponse.flatMap(_(performRequest(request, credential))).transform[Call](
        { Call(_) },{checkExceptions}
      )

    }

  }

  implicit object IncomingPhoneNumberExecutor extends OperationExecutor[IncomingPhoneNumberRequest, IncomingPhoneNumber]{
    def execute(request: IncomingPhoneNumberRequest) (credential: Credential): Future[IncomingPhoneNumber] = {
      val fResponse = pipeline.map( p => p ~> unmarshal[IncomingPhoneNumberJson])
      fResponse.flatMap(_(performRequest(request, credential))).transform[IncomingPhoneNumber](
        { IncomingPhoneNumber(_) },{checkExceptions}
      )
    }

  }

  implicit object IncomingPhoneNumbersExecutor extends OperationExecutor[IncomingPhoneNumbersRequest, IncomingPhoneNumbers]{
    def execute(request: IncomingPhoneNumbersRequest) (credential: Credential): Future[IncomingPhoneNumbers] = {
      val fResponse = pipeline.map( p => p ~> unmarshal[IncomingPhoneNumbersJson])
      fResponse.flatMap(_(performRequest(request, credential))).transform[IncomingPhoneNumbers](
        { IncomingPhoneNumbers(_) },{checkExceptions}
      )
    }

  }

}

