package com.failfast.twilio.json

case class TokenJson(username: String,
                     password: String,
                     ttl: String,
                     account_sid: String,
                     ice_servers: Seq[IceServerJson],
                     date_created: Option[String],
                     date_updated: Option[String]
                    )
