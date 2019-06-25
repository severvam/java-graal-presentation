package computerdatabase

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class BasicSimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("http://localhost:8080/loans") // Here is the root for all relative URLs
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")

  val scn = scenario("Scenario Check Memory difference between Java frameworks") // A scenario is a chain of requests and pauses
    .exec(http("request_1")
      .get("/all"))
    .pause(7) // Note that Gatling has recorder real time pauses
    .exec(http("request_2")
      .get("/last/10"))
    .pause(2)
    .exec(http("request_3")
      .get("/last/6"))
    .pause(3)
    .exec(http("request_4")
      .get("/last/200"))
    .pause(2)
    .exec(http("request_5")
      .get("/last/133"))
    .pause(670 milliseconds)
    .exec(http("request_6")
      .get("/last/5"))
    .pause(629 milliseconds)
    .exec(http("request_7")
      .get("/last/111"))
    .pause(734 milliseconds)
    .exec(http("request_8")
      .get("/last/15"))
    .pause(5)
    .exec(http("request_9")
      .get("/last/100"))

  setUp(scn.inject(atOnceUsers(20)).protocols(httpProtocol))
}
