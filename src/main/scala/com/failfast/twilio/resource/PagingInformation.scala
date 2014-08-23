package com.failfast.twilio.resource

case class PagingInformation(
                              page: Int,
                              numPages: Int,
                              pageSize: Int,
                              total: Int,
                              start: Int,
                              end: Int,
                              uri: String,
                              firstPageUri: Option[String],
                              previousPageUri: Option[String],
                              nextPageUri: Option[String],
                              lastPageUri: Option[String]
                              )
