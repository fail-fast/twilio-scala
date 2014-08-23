package com.failfast.twilio.http

case object PostRequest extends HttpMethod{
  val name: String = "POST"
}

case object GetRequest extends HttpMethod{
  val name: String = "GET"
}

case object DeleteRequest extends HttpMethod{
  val name: String = "DELETE"
}

case object PutRequest extends HttpMethod{
  val name: String = "PUT"
}

case object OptionsRequest extends HttpMethod{
  val name: String = "OPTIONS"
}

case object PatchRequest extends HttpMethod{
  val name: String = "Patch"
}