package com.failfast.twilio.json

case class IncomingPhoneNumbersJson(
                                     page: Int,
                                     num_pages: Int,
                                     page_size: Int,
                                     total: Int,
                                     start: Int,
                                     end: Int,
                                     uri: String,
                                     first_page_uri: Option[String],
                                     previous_page_uri: Option[String],
                                     next_page_uri: Option[String],
                                     last_page_uri: Option[String],
                                     incoming_phone_numbers: Seq[IncomingPhoneNumberJson] )
