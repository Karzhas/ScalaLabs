
import akka.actor.typed.{ActorSystem, Behavior}
import akka.actor.typed.scaladsl.{AbstractBehavior, ActorContext}

import scala.io.StdIn



object Main{

    def main(args: Array[String]): Unit = {
    val input : String = StdIn.readLine()
    val brain = ActorSystem(Brain(), "Brain")

    brain ! InputFromUser(input)

  }
}

