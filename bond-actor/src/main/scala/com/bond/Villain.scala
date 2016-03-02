package com.bond

import akka.actor._
import com.bond.SpecialAgent.Peng

object Villain {

  def props(target: ActorRef, noOfSeconds: Int) = Props(new Villain(target, noOfSeconds))
  case class MissedMe()
  case class Shoot()
  case class Paff()

}

class Villain(target: ActorRef, noOfSeconds: Int) extends Actor with ActorLogging  {

  import scala.concurrent.duration._
  import context._

  import Villain._

  override def preStart() = {
    log.info("I'm " + self.path.name + ", and I'll get " + target.path.name +"!")
    // There will be periodical attempts to shoot the target
    context.system.scheduler.schedule(noOfSeconds seconds, noOfSeconds seconds, self, Shoot())
  }

  def receive = {

    case Shoot() =>
      log.info("Peng.")
      target ! Peng()

    case MissedMe() =>
      log.info("Damned!")

    case Paff() =>
      log.info("Aaaarghh...")
      self ! PoisonPill

  }

}
