package com.bond

import akka.actor.{Actor, ActorLogging, Props}
import com.bond.Villain.Paff

object SpecialAgent {
  val props = Props[SpecialAgent]
  case class Peng()
  case class GetSerious()
}

class SpecialAgent extends Actor with ActorLogging {

  import SpecialAgent._
  import com.bond.Villain.MissedMe

  def receive = {

    // start in leisure mode
    case msg: AnyRef => leisureMode(msg)

  }

  def leisureMode: Receive = {

    case Peng() =>
      log.info("Haha, you missed me, " + sender().path.name + "!")
      sender() ! MissedMe()

    case GetSerious() =>
      log.info("Now I'll shoot back....")
      context.become(doubleZeroMode)

  }

  def doubleZeroMode: Receive = {

    case Peng() =>
      log.info("Paff. Take that, " + sender().path.name + "!")
      sender() ! Paff()

  }

}

