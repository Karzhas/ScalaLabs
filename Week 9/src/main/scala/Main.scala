
import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors



object Main extends App {


val guardianActor = Behaviors.setup[Nothing] { context =>
    implicit val ec = context.executionContext
    implicit val sys = context.system
    val calcActor = context.spawn(Calculator(), name = "CalcActor")
    //context.watch(calcActor)

    val routes = new CalculatorRouter(calcActor)
    Server.startHttpServer(routes.route)

    Behaviors.empty
  }
  val system = ActorSystem[Nothing](guardianActor, "CalcActor")



}