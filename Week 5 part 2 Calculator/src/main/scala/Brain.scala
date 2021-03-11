import akka.actor.typed.{ActorSystem, Behavior, Scheduler}
import akka.actor.typed.scaladsl.AskPattern.Askable
import akka.actor.typed.scaladsl.{AbstractBehavior, ActorContext, Behaviors}
import akka.util.Timeout

import scala.concurrent.duration.DurationInt


sealed trait Msg
case class InputFromUser(input: String) extends Msg
case class Response(result: Int) extends Msg
object Brain {
  def apply(): Behavior[Msg] =
    Behaviors.setup(context => new Brain(context))
}

class Brain(context: ActorContext[Msg]) extends AbstractBehavior[Msg](context){
  private def isStringNumber(str : String) : Boolean = str forall(_.isDigit)

  override def onMessage(msg: Msg): Behavior[Msg] =
    msg match {
      case InputFromUser(input) =>
        val calculator = context.spawn(Calculator(), "calculator")
        val partition = input.split(" ").partition(isStringNumber)
        val numbers = partition._1.map(_.toInt)
        val commands = partition._2
        calculator ! Request(CalculationData(numbers,commands), context.self)
        this
      case Response(result) =>
        val printer = context.spawn(Printer(), "printer")
        printer ! result.toString
        this
    }
}