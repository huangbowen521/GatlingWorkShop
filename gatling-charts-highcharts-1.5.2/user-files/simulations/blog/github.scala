package blog

import com.excilys.ebi.gatling.core.Predef._
import com.excilys.ebi.gatling.http.Predef._
import com.excilys.ebi.gatling.jdbc.Predef._
import com.excilys.ebi.gatling.http.Headers.Names._
import akka.util.duration._
import bootstrap._

class GithubSimulation extends Simulation {
	var httpConf = httpConfig.
	baseURL("https://github.com")

	var scn = scenario("search in github.com")
	.exec(
		http("home page")
		.get("/")
		.check(status.is(200)))
	.pause(0, 12)
	.exec(
		http("do search")
		.get("/search")
		.queryParam("q", "gatling")
		.check(status.is(200)))

	setUp(scn.users(500).ramp(10).protocolConfig(httpConf))
}