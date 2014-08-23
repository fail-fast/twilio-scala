package com.failfast.twilio.resource

case class Capabilities(voice: Boolean, sms: Boolean, mms: Boolean)

/** This is mapped to json from the API response, and Twilio is sending back the attributes in capital letter */
case class CapabilitiesAvailableNumbers(voice: Boolean, SMS: Boolean, MMS: Boolean)
