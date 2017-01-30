package com.failfast.twilio.executor

import com.failfast.twilio.Credential
import com.failfast.twilio.request._
import com.failfast.twilio.resource.{Mobile, TollFree, Local}
import scala.language.implicitConversions

class EndpointLocator[A <: TwilioRequest, B <: Endpoint]{

  def endpoint(request: TwilioRequest, credential: Credential)(implicit f:  (TwilioRequest, Credential) => B): B = f(request, credential)

}

trait Endpoint {
  val url: String

}

case class EndpointImpl(url: String) extends Endpoint


object Endpoints{

  implicit def accountEndpoint(r: AccountRequest, credential: Credential): Endpoint = EndpointImpl(s"/Accounts/${credential.sid}.json")
  implicit def createTokenEndpoint(r: CreateTokenRequest, credential: Credential): Endpoint = EndpointImpl(s"/Accounts/${credential.sid}/Tokens.json")
  implicit def updateAccountEndpoint(r: UpdateAccountRequest, credential: Credential): Endpoint = EndpointImpl(s"/Accounts/${credential.sid}.json")
  implicit def accountsEndpoint(r: AccountsRequest, credential: Credential): Endpoint = EndpointImpl(s"/Accounts.json")
  implicit def sendSmsEndpoint(r: SmsRequest, credential: Credential): Endpoint = EndpointImpl(s"/Accounts/${credential.sid}/Messages.json")
  implicit def availablePhoneNumbersLocalEndpoint(r: AvailablePhoneNumbersLocalRequest, credential: Credential): Endpoint = EndpointImpl(s"/Accounts/${credential.sid}/AvailablePhoneNumbers/${r.isoCountryCode}/Local.json")
  implicit def availablePhoneNumbersMobileRequestEndpoint(r: AvailablePhoneNumbersMobileRequest, credential: Credential): Endpoint = EndpointImpl(s"/Accounts/${credential.sid}/AvailablePhoneNumbers/${r.isoCountryCode}/Mobile.json")
  implicit def availablePhoneNumbersTollFreeRequestEndpoint(r: AvailablePhoneNumbersTollFreeRequest, credential: Credential): Endpoint = EndpointImpl(s"/Accounts/${credential.sid}/AvailablePhoneNumbers/${r.isoCountryCode}/TollFree.json")
  implicit def callEndpoint(r: CallRequest, credential: Credential): Endpoint = EndpointImpl(s"/Accounts/${credential.sid}/Calls.json")
  implicit def liveCallEndpoint(r: LiveCallRequest, credential: Credential): Endpoint = EndpointImpl(s"/Accounts/${credential.sid}/Calls/${r.callSid}.json")
  implicit def sipCallEndpoint(r: SipCallRequest, credential: Credential): Endpoint = EndpointImpl(s"/Accounts/${credential.sid}/Calls.json")
  implicit def incomingPhoneNumberEndpoint(r: IncomingPhoneNumberRequest, credential: Credential): Endpoint = EndpointImpl(s"/Accounts/${credential.sid}/IncomingPhoneNumbers/${r.incomingPhoneNumber}.json")
  implicit def incomingPhoneNumbersEndpoint(r: IncomingPhoneNumbersRequest, credential: Credential): Endpoint = {

    r.phoneNumberType.map{
      case Local => EndpointImpl(s"/Accounts/${credential.sid}/IncomingPhoneNumbers/Local.json")
      case TollFree => EndpointImpl(s"/Accounts/${credential.sid}/IncomingPhoneNumbers/TollFree.json")
      case Mobile => EndpointImpl(s"/Accounts/${credential.sid}/IncomingPhoneNumbers/Mobile.json")
      case _ => EndpointImpl(s"/Accounts/${credential.sid}/IncomingPhoneNumbers.json")
    }.getOrElse(EndpointImpl(s"/Accounts/${credential.sid}/IncomingPhoneNumbers.json"))

  }




}