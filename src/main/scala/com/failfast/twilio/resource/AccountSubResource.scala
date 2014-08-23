package com.failfast.twilio.resource

import com.failfast.twilio.json.AccountSubResourceJson

case class AccountSubResource(availablePhoneNumbers: String, calls: String, conferences: String, incomingPhoneNumbers: String, notifications: String, outgoingCallerIds: String, recordings: String, sandbox: String, smsMessages: String, transcriptions: String)

object AccountSubResource{

  def apply(json: AccountSubResourceJson): AccountSubResource = {

    AccountSubResource(
      json.available_phone_numbers,
      json.calls,
      json.conferences,
      json.incoming_phone_numbers,
      json.notifications,
      json.outgoing_caller_ids,
      json.recordings,
      json.sandbox,
      json.sms_messages,
      json.transcriptions
    )

  }
}
