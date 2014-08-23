package com.failfast.twilio.resource

import com.failfast.twilio.json.AvailablePhoneNumbersJson
import com.failfast.twilio.response.TwilioResponse

case class AvailablePhoneNumbers(uri: String, availablePhoneNumbers: Seq[AvailablePhoneNumber] ) extends TwilioResponse

case class AvailablePhoneNumber(friendlyName: String, phoneNumber: String, isoCountry: String, capabilities: CapabilitiesAvailableNumbers, lata: Option[String] = None, rateCenter: Option[String] = None, latitude: Option[String] = None, longitude: Option[String] = None, postalCode: Option[String] = None)

object AvailablePhoneNumbers{

  def apply(json: AvailablePhoneNumbersJson): AvailablePhoneNumbers = {

    AvailablePhoneNumbers(
      uri = json.uri,
      availablePhoneNumbers =
        json.available_phone_numbers.map{ availablePhoneNumber =>

          AvailablePhoneNumber(
            availablePhoneNumber.friendly_name,
            availablePhoneNumber.phone_number,
            availablePhoneNumber.iso_country,
            availablePhoneNumber.capabilities,
            availablePhoneNumber.lata,
            availablePhoneNumber.rate_center,
            availablePhoneNumber.latitude,
            availablePhoneNumber.longitude,
            availablePhoneNumber.postal_code
          )
        }

    )
  }
}