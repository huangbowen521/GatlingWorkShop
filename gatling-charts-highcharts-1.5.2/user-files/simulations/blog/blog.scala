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
	.acceptCharsetHeader("ISO-8859-1,utf-8:q=0.7,*;q=0.7")
	.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
	.acceptEncodingHeader("gzip, deflate")
	.acceptLanguageHeader("fr,fr-fr;q=0.8,en-us;q=0.5,en;q=0.3")
	.disableFollowRedirect


var httpConf2 = httpConfig
	.baseURL("http://huangbowen521.github.io")
	.acceptCharsetHeader("ISO-8859-1,utf-8:q=0.7,*;q=0.7")
	.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
	.acceptEncodingHeader("gzip, deflate")
	.acceptLanguageHeader("fr,fr-fr;q=0.8,en-us;q=0.5,en;q=0.3")
	.disableFollowRedirect


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