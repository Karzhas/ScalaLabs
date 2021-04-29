import akka.actor.typed.{ActorRef, Behavior}
import akka.actor.typed.scaladsl.{AbstractBehavior, ActorContext, Behaviors}

object Calculator {

  trait Command
  case class Calculate(expression: String, replyTo: ActorRef[String]) extends Command
  def isStringNumber(str : String) : Boolean = str forall(_.isDigit)
  private def calculate(): Behavior[Command] =
    Behaviors.receiveMessage {
      case Calculate(expression, replyTo) =>

        val partition = expression.replace(' ', '+').split("(?<=[-+*/])|(?=[-+*/])").partition(isStringNumber)
        val numbers = partition._1.map(_.toInt)
        val operators = partition._2
        var result = numbers(0)
        var ind = 0
        for (i <- 1 until numbers.length) {
          operators(ind) match {
            case "+" => result += numbers(i)
            case "-" => result -= numbers(i)
            case "*" => result *= numbers(i)
            case "/" => result /= numbers(i)
          }
          ind += 1
          Behaviors.same
        }
        replyTo ! result.toString
        Behaviors.same
    }
  def apply() : Behavior[Command] = {calculate()}

}





//class Calculator(context: ActorContext[Request]) extends AbstractBehavior[Request](context){
//  override def onMessage(msg: Request): Behavior[Request] =
//    msg match {
//      case Request(calcData, replyTo) =>
//        val numbers = calcData.numbers
//        val commands = calcData.commands
//        var commIterator = 0
//        var result = numbers(0)
//        for(i <- 1 until numbers.length){
//          commands(commIterator) match {
//            case "+" => result += numbers(i)
//            case "-" => result -= numbers(i)
//            case "*" => result *= numbers(i)
//            case "/" => result /= numbers(i)
//          }
//          commIterator += 1
//        }
//        replyTo ! Response(result)
//        this
//    }
//}