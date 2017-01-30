package com.failfast.twilio.json

case class TokenJson(username: String,
                     password: String,
                     ttl: Int,
                     account_sid: String,
                     ice_servers: Seq[String],
                     date_created: Option[String],
                     date_updated: Option[String]
                    )
