package blog

import com.excilys.ebi.gatling.core.Predef._
import com.excilys.ebi.gatling.http.Predef._
import com.excilys.ebi.gatling.jdbc.Predef._
import com.excilys.ebi.gatling.http.Headers.Names._
import akka.util.duration._
import bootstrap._

class BlogSimulation extends Simulation {

	var httpConf = httpConfig
	.baseURL("http://www.huangbowen.net")


var httpConf2 = httpConfig
	.baseURL("http://huangbowen521.github.io")


	var scn = scenario("View homepage in AWS")
	.exec(
		http("request_1")
		.get("/"))
	.pause(0, 13)


	var scn2 = scenario("View homepage in Github")
	.exec(
		http("request_1")
		.get("/"))
	.pause(0, 13) 


	setUp(scn.users(1000).ramp(10).protocolConfig(httpConf),
		scn2.users(1000).ramp(10).protocolConfig(httpConf2)
		)
}