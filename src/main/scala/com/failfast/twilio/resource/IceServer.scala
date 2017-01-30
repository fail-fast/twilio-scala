package com.failfast.twilio.resource

import com.failfast.twilio.json.IceServerJson
import com.failfast.twilio.response.TwilioResponse

case class IceServer(url: String) extends TwilioResponse

object IceServer{
  def apply(iceJson: IceServerJson): IceServer = {
    IceServer(
      iceJson.url
    )
  }
}





