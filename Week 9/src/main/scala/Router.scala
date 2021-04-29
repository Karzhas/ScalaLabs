import Calculator.Calculate
import akka.actor.typed.{ActorRef, ActorSystem}
import akka.actor.typed.scaladsl.AskPattern.{Askable, schedulerFromActorSystem}
import akka.http.scaladsl.server.{Directives, Route}
import akka.util.Timeout

import scala.concurrent.Future
import scala.concurrent.duration.DurationInt

trait Router {
  def route: Route
}

class CalculatorRouter(calculateActor: ActorRef[Calculator.Command])(implicit val system: ActorSystem[_]) extends Router
                                                                          with Directives
                                                                          with CalculatorDirectives
                                                                          with ValidatorDirectives {
  import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport._
  private implicit val timeout = Timeout(3.seconds)

  def calculateExpression(expression: String): Future[String] =
    calculateActor.ask(Calculate(expression, _))

  override def route: Route =  concat(
    path("calculate") {
      get {
        parameters('expression.as[String]) { expression =>
          validateWith(CalculateExpressionValidator)(expression){
            complete {
              calculateExpression(expression)
            }
          }
        }
      }
    }
  )
}