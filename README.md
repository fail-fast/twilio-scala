----------
twilio-scala
============

Implementation of a non blocking Twilio client in Scala based on Spray.io.

### Key features of the library
- Non blocking with Futures
- Set of Twilio Rest services


### Project Dependencies

```scala
libraryDependencies ++= Seq(
  "systems.fail-fast" %% "twilio-scala" % "0.2"
)
```

### Do you want compile it yourself?
```bash
$ git clone git@github.com:fail-fast/twilio-scala
$ cd twilio-scala
$ sbt compile
```

### Sample usage

```scala
// Create a rest client
val client = TwilioRestClient("YOUR_SID", "YOUR_AUTH_TOKEN")

// Get the main account (The one used to authenticate the client)
val request = AccountRequest()
val futureAccountInfo: Future[Account] = client.execute[AccountRequest, Account](request)

// Get all accounts including sub accounts
val request = AccountsRequest(status = Option("active"), page = Option(0), pageSize = Option(5))
val futureAccounts: Future[Accounts] = client.execute[AccountsRequest, Accounts](request)

// Make a call
val request = CallRequest(from = "add a valid phone number", to = "add a valid phone number", url = Option("http://twimlets.com/message?Message=Hello"))
val futureCall: Future[Call] = client.execute[CallRequest, Call](request)

// Send an sms
val request = SmsRequest(from = "add a valid phone number", to = "add a valid phone number", body = Option("what's up?"))
val futureMessage: Future[Message] = client.execute[SmsRequest, Message](request)

//Get Incoming phone number
val request = IncomingPhoneNumberRequest(incomingPhoneNumber = "some valid phone number")
val futureNumber: Future[IncomingPhoneNumber] = client.execute[IncomingPhoneNumberRequest, IncomingPhoneNumber](request)

//Get Local Incoming phone number
val request = IncomingPhoneNumbersRequest(phoneNumberType = Option(Local))
val futureNumbers = client.execute[IncomingPhoneNumbersRequest, IncomingPhoneNumbers](request)
      
//Get Mobile Incoming phone number
val request = IncomingPhoneNumbersRequest(phoneNumberType = Option(Mobile))
val futureNumbers = client.execute[IncomingPhoneNumbersRequest, IncomingPhoneNumbers](request)

//Update account information
val request = UpdateAccountRequest(friendlyName = Option("my new friendly Name"))
val futureAccountInfo: Future[Account] = client.execute[UpdateAccountRequest, Account](request)

      


```

### License

This software is licensed under the Apache 2 license, quoted below.

Licensed under the Apache License, Version 2.0 (the "License"); you may not
use this file except in compliance with the License. You may obtain a copy of
the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
License for the specific language governing permissions and limitations under
the License.


