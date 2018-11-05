/*-
 * <<
 * Moonbox
 * ==
 * Copyright (C) 2016 - 2018 EDP
 * ==
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * >>
 */

package moonbox.grid.deploy2.rest

import akka.Done
import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.Http.ServerBinding
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server._
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.Sink
import de.heikoseeberger.akkahttpjson4s.Json4sSupport.ShouldWritePretty
import moonbox.protocol.client._
import moonbox.common.{MbConf, MbLogging}
import moonbox.grid.{ConnectionInfo, ConnectionType}
import moonbox.grid.config._
import moonbox.grid.deploy2.MbService
import org.json4s.jackson.Serialization
import org.json4s.{CustomSerializer, DefaultFormats, JInt, JString}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

class RestServer(host: String, port: Int, conf: MbConf, service: MbService,
	implicit val akkaSystem: ActorSystem) extends JsonSerializer with MbLogging {

	private val maxRetries: Int = conf.get(PORT_MAX_RETRIES.key, PORT_MAX_RETRIES.defaultValue.get)
	private var bindingFuture: Future[ServerBinding] = _
	private val loginManager = service.getLoginManager()
	implicit val materializer = ActorMaterializer()
	implicit val formats = DefaultFormats +   //add custom special serializer
		new CustomSerializer[java.sql.Date]( _ =>
			(	{ case JInt(s) => new java.sql.Date(s.longValue())},
				{ case x: java.sql.Date => JString(x.toString)})) +
		new CustomSerializer[java.math.BigDecimal]( _ =>
			(	{ case JString(s) => new java.math.BigDecimal(s) },
				{ case b: java.math.BigDecimal => JString(b.toString)}))

	implicit val serialization = Serialization
	implicit val shouldWritePretty = ShouldWritePretty.True


	//val routes: Route = {
	def routes(implicit connectionInfo: ConnectionInfo): Route = {
		path("login") {
			post {
				entity(as[LoginInbound]) { in =>
					complete {
						service.login(in.username, in.password)
					}
				}
			}
		} ~
		path("logout") {
			post {
				entity(as[LogoutInbound]) { in =>
					complete {
						loginManager.isvalid(in.token) match {
							case false =>
								LogoutOutbound(error = Some("Token is incorrect or expired."))
							case true =>
								service.logout(in.token)
						}
					}
				}
			}
		} ~
		path("openSession") {
			post {
				entity(as[OpenSessionInbound]) { in =>
					complete {
						loginManager.isvalid(in.token) match {
							case false =>
								OpenSessionOutbound(error = Some("Token is incorrect or expired."))
							case true =>
								service.openSession(in.token, in.database, in.isLocal)
						}
					}
				}
			}
		} ~
		path("closeSession") {
			post {
				entity(as[CloseSessionInbound]) { in =>
					complete {
						loginManager.isvalid(in.token) match {
							case false =>
								CloseSessionOutbound(error = Some("Token is incorrect or expired."))
							case true =>
								service.closeSession(in.token, in.sessionId)
						}
					}
				}
			}
		} ~
		path("query") {
			post {
				entity(as[InteractiveQueryInbound]) { in =>
					complete {
						loginManager.isvalid(in.token) match {
							case false =>
								InteractiveQueryOutbound(error = Some("Token is incorrect or expired."))
							case true =>
								service.interactiveQuery(in.token, in.sessionId, in.sqls)
						}
					}
				}
			}
		} ~
		path("nextResult") {
			post {
				entity(as[InteractiveNextResultInbound]) { in =>
					complete {
						loginManager.isvalid(in.token) match {
							case false =>
								InteractiveNextResultOutbound(error = Some("Token is incorrect or expired."))
							case true =>
								service.interactiveNextResult(in.token, in.sessionId, in.cursor, in.fetchSize)
						}
					}
				}
			}
		} ~
		path("submit") {
			post {
				entity(as[BatchQueryInbound]) { in =>
					complete {
						loginManager.isvalid(in.token) match {
							case false => BatchQueryOutbound(error = Some("Token is incorrect or expired."))
							case true =>
								service.batchQuery(in.token, in.sqls, in.config)
						}
					}
				}
			}
		} ~
		path("progress") {
			post {
				entity(as[BatchQueryProgressInbound]) { in =>
					complete {
						loginManager.isvalid(in.token) match {
							case false =>
								BatchQueryProgressOutbound(error = Some("Token is incorrect or expired."))
							case true =>
								service.batchQueryProgress(in.token, in.jobId)
						}
					}
				}
			}
		}  ~
		path("cancel") {
			post {
				entity(as[CancelQueryInbound]) { in =>
					complete {
						loginManager.isvalid(in.token) match {
							case false =>
								CancelQueryOutbound(error = Some("Token is incorrect or expired."))
							case true =>
								service.cancelQuery(in.token, in.jobId)
						}
					}
				}
			}
		} ~
		path("requestAccess") {
			post {
				entity(as[RequestAccessInbound]) { in =>
					complete {
						loginManager.isvalid(in.token.getOrElse("")) match {
							case false =>
								RequestAccessOutbound(None, error = Some("Token is incorrect or expired."))
							case true =>
								service.requestAccess(in.token.getOrElse(""), in.isLocal, ConnectionType.REST)
						}
					}
				}
			}
		} ~
		path("addYarnApp") {
			post {
				entity(as[AddAppInbound]) { in =>
					complete {
						service.yarnAppAdd(in.username, in.config)
					}
				}
			}
		} ~
		path("removeYarnApp") {
			post {
				entity(as[RemoveAppInbound]) { in =>
					complete {
						service.yarnAppRemove(in.username, in.appId)
					}
				}
			}
		} ~
		path("showYarnApp") {
			post {
				entity(as[ShowAppInbound]) { in =>
					complete {
						service.yarnAppShow(in.username)
					}
				}
			}
		} ~
		path("showNodesInfo") {
			post {
				entity(as[ShowNodesInfoInbound]) { in =>
					complete {
						service.nodesInfoShow(in.token)
					}
				}
			}
		} ~
		path("metadata" / "showDatabases") { //第一次请求，moonbox将所有的数据库名 数据库连接信息 和 该标签，一起返回，比如（tag，（databasename， URL））
			post {
				entity(as[ShowDatabasesInbound]) { in =>
					complete {
						loginManager.isvalid(in.token) match {
							case false => ShowDatabasesOutbound(error = Some("Token is incorrect or expired."))
							case true =>
								service.databasesShow(in.token)
						}
					}
				}
			}
		} ~
		path("metadata" / "showTables") {  //第二次请求根据数据库去获取该库下所有表名
			post {
				entity(as[ShowTablesInbound]) { in =>
					complete {
						loginManager.isvalid(in.token) match {
							case false => ShowTablesOutbound(error = Some("Token is incorrect or expired."))
							case true =>
								service.tablesShow(in.token, in.database)
						}
					}
				}
			}
		} ~
		path("metadata" / "describeTable") {  //第三次请求根据表名获取所有字段信息
			post {
				entity(as[DescribeTablesInbound]) { in =>
					complete {
						loginManager.isvalid(in.token) match {
							case false => DescribeTablesOutbound(error = Some("Token is incorrect or expired."))
							case true =>
								service.tableDescribe(in.token, in.table, in.database)
						}
					}
				}
			}
		}

	}

	def start(): Int = {
		require(port == 0 || (port >= 1024 && port < 65535),
			"rest port should be between 1024 (inclusive) and 65535 (exclusive), or 0 for a random free port.")
		logInfo("Starting RestServer ...")
		for (offset <- 0 to maxRetries) {
			val tryPort = if (port == 0) port else port + offset
			try {
				//bindingFuture = Http().bindAndHandle(routes, host, tryPort)
				//val serverBinding: ServerBinding = Await.result(bindingFuture, new FiniteDuration(10, SECONDS))
				//logInfo(s"RestServer is listening on ${serverBinding.localAddress.toString}.")
				//return serverBinding.localAddress.getPort
				val f: Future[Done] = Http().bind(host, tryPort).runWith(Sink foreach { conn =>
					val client =  conn.remoteAddress
					val local = conn.localAddress
					val connectionInfo = ConnectionInfo(client, local, ConnectionType.REST)
					conn.handleWith(routes(connectionInfo))
				})
				logInfo(s"RestServer is listening on $tryPort.")
				return tryPort
			} catch {
				case e: Exception =>
					if (offset >= maxRetries) {
						throw e
					}
					if (port == 0) {
						logWarning(s"RestServer could not bind on a random free pot. Attempting again.")
					} else {
						logWarning(s"RestServer could not bind on port $tryPort. " + "" +
							s"Attempting port ${tryPort + 1}")
					}
			}
		}
		throw new Exception(s"Failed to start RestServer on port $port")
	}

	def stop(): Unit = {
		if (bindingFuture != null) {
			bindingFuture.flatMap(_.unbind())
		}
	}

}
