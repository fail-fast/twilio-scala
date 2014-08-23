package com.failfast.twilio.json

import com.failfast.twilio.resource.{CapabilitiesAvailableNumbers}

case class AvailablePhoneNumberJson(friendly_name: String, phone_number: String, iso_country: String, capabilities: CapabilitiesAvailableNumbers, lata: Option[String] = None, rate_center: Option[String] = None, latitude: Option[String] = None, longitude: Option[String] = None, postal_code: Option[String] = None)