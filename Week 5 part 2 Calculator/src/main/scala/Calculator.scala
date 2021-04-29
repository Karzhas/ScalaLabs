import akka.actor.typed.{ActorRef, Behavior}
import akka.actor.typed.scaladsl.{AbstractBehavior, ActorContext, Behaviors}

import scala.math.pow

case class CalculationData(numbers: Array[Int], commands: Array[String])
case class Request(calcData : CalculationData, replyTo: ActorRef[Msg])
object Calculator {
  def apply(): Behavior[Request] =
    Behaviors.setup(context => new Calculator(context))

}
class Calculator(context: ActorContext[Request]) extends AbstractBehavior[Request](context){
  override def onMessage(msg: Request): Behavior[Request] =
    msg match {
      case Request(calcData, replyTo) =>
        val numbers = calcData.numbers
        val commands = calcData.commands
        var commIterator = 0
        var result = numbers(0)
        for(i <- 1 until numbers.length){
          commands(commIterator) match {
            case "+" => result += numbers(i)
            case "-" => result -= numbers(i)
            case "*" => result *= numbers(i)
            case "/" => result /= numbers(i)
            case "^" => result = pow(result, numbers(i)).toInt
          }
          commIterator += 1
        }
        replyTo ! Response(result)
        this
    }
}