package com.failfast.twilio.resource

import com.failfast.twilio.json.AccountJson
import com.failfast.twilio.response.TwilioResponse

case class Account(sid: String, ownerAccountSid: String, friendlyName: String, status: String, dateCreated: String, dateUpdated: String, authToken: String, uri: String, subResources: AccountSubResource) extends TwilioResponse

object Account{
  def apply(accJson: AccountJson): Account = {
    Account(
      accJson.sid,
      accJson.owner_account_sid,
      accJson.friendly_name,
      accJson.status,
      accJson.date_created,
      accJson.date_updated,
      accJson.auth_token,
      accJson.uri,
      AccountSubResource(accJson.subresource_uris)
    )
  }
}

