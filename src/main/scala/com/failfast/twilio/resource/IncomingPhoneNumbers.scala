package com.failfast.twilio.resource

import com.failfast.twilio.json.IncomingPhoneNumbersJson
import com.failfast.twilio.response.TwilioResponse

case class IncomingPhoneNumbers(pagingInfo: PagingInformation, incomingPhoneNumbers: Seq[IncomingPhoneNumber]) extends TwilioResponse


object IncomingPhoneNumbers{

  def apply(json: IncomingPhoneNumbersJson): IncomingPhoneNumbers = {

    val pagingInformation = PagingInformation(
      json.page,
      json.num_pages,
      json.page_size,
      json.total,
      json.start,
      json.end,
      json.uri,
      json.first_page_uri,
      json.previous_page_uri,
      json.next_page_uri,
      json.last_page_uri
    )

    IncomingPhoneNumbers(pagingInfo = pagingInformation, incomingPhoneNumbers = json.incoming_phone_numbers.map(IncomingPhoneNumber(_)))

  }

}
