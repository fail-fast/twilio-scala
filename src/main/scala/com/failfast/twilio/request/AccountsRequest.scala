package com.failfast.twilio.request

import com.failfast.twilio.http.{GetRequest, HttpMethod}

/**
 * See twilio doc: https://www.twilio.com/docs/api/rest/account#list
 */

case class AccountsRequest(friendlyName: Option[String] = None, status: Option[String] = None, page: Option[Int] = None, pageSize: Option[Int] = None) extends TwilioRequest{

  override def httpMethod: HttpMethod = GetRequest

  override def fields: Seq[(String, String)] = Seq()

  override def query: Option[String] = {
    val pageParam = concat(buildQuery("Page", page.map(p => p.toString)), _:Option[String])
    val pageSizeParam = concat(buildQuery("PageSize", pageSize.map(p => p.toString)), _:Option[String])
    (pageParam andThen pageSizeParam)(concat(buildQuery("FriendlyName", friendlyName), buildQuery("Status", status))) map (v => s"?$v")
  }


}
