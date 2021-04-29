import akka.actor.typed.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Route

import scala.concurrent.ExecutionContext
import scala.util.{Failure, Success, Try}

object Server{
  val host = "0.0.0.0"
  val port = Try(System.getenv("PORT")).map(_.toInt).getOrElse(9000)
  def startHttpServer(routes: Route)(implicit system: ActorSystem[_],  ex:ExecutionContext): Unit = {
    val futureBinding = Http().newServerAt(host, port).bind(routes)
    futureBinding.onComplete {
      case Success(binding) =>
        val address = binding.localAddress
        "sucess"
      case Failure(ex) =>
        "fail"
    }
  }

}