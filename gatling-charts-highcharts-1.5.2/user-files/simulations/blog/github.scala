package blog

import com.excilys.ebi.gatling.core.Predef._
import com.excilys.ebi.gatling.http.Predef._
import com.excilys.ebi.gatling.jdbc.Predef._
import com.excilys.ebi.gatling.http.Headers.Names._
import akka.util.duration._
import bootstrap._

class GoogleSimulation extends Simulation {
	var httpConf = httpConfig.
	baseURL("https://www.github.com")

	var scn = scenario("search in github.com")
	.exec(
		http("home page")
		.get("/")
		.check(status.is(200)))
	// .pause(0, 12)
	// .exec(
	// 	http("do search")
	// 	.get("/")
	// 	.queryParam("q", "Gatling")
	// 	.check(status.is(200)))

	setUp(scn.users(10).ramp(60).protocolConfig(httpConf))
}