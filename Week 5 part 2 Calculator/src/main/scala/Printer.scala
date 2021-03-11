import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.{AbstractBehavior, ActorContext, Behaviors}
import akka.event.Logging
import org.slf4j.Marker


object Printer {
  def apply(): Behavior[String] =
    Behaviors.setup(context => new Printer(context))
}

class Printer(context: ActorContext[String]) extends AbstractBehavior[String](context){
  override def onMessage(msg: String): Behavior[String] = {
    context.log.info(msg)
    this
  }
}