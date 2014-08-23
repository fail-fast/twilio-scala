package com.failfast.twilio.resource

import com.failfast.twilio.json.AccountsJson
import com.failfast.twilio.response.TwilioResponse

case class Accounts(pagingInformation: PagingInformation, accounts: Seq[Account]) extends TwilioResponse

object Accounts{

  def apply(json: AccountsJson): Accounts = {

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

    Accounts(pagingInformation, json.accounts.map(Account(_)))

  }
}
