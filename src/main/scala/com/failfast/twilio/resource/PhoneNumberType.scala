package com.failfast.twilio.resource

sealed trait PhoneNumberType

case object Local extends PhoneNumberType
case object TollFree extends PhoneNumberType
case object Mobile extends PhoneNumberType