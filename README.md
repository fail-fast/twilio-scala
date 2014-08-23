twilio-scala
============

Implementation of a non blocking Twilio client in Scala based on Akka-http(Spray).

### Key features of the library
- Non blocking with Futures
- Full set of Twilio Rest services


### Project Dependencies

```scala
libraryDependencies ++= Seq(
  "" %% "twilio-scala" % "0.2"
)
```

### Sample usage

```scala

val client = TwilioRestClient("YOUR_SID", "YOUR_AUTH_TOKEN")
val getAccountsRequest = AccountsRequest(friendlyName = Option("your name"), status = Option("active"), page = Option(0), pageSize = Option(5))
val futureAccounts = client.execute[AccountsRequest, Accounts](getAccountsRequest)

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
