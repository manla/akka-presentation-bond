package com.bond

import akka.actor.{Props, ActorRef, ActorLogging, Actor}


object Regisseur {

  def props(hero: ActorRef, secondsAction: Int, secondsTotal: Int) =
    Props(new Regisseur(hero, secondsAction, secondsTotal))

  case class Action()
  case class End()

}

class Regisseur(hero: ActorRef, secondsAction: Int, secondsTotal: Int) extends Actor with ActorLogging  {

  import scala.concurrent.duration._
  import scala.concurrent.ExecutionContext.Implicits.global
  import com.bond.Regisseur._
  import com.bond.SpecialAgent.GetSerious

  override def preStart() = {

    log.info("Action in " + secondsAction + " seconds.")
    context.system.scheduler.scheduleOnce(secondsAction seconds, self, Action())

    log.info("We have " + secondsTotal + " seconds in total.")
    context.system.scheduler.scheduleOnce(secondsTotal seconds, self, End())
  }

  def receive = {

    case Action() =>
      log.info("Now Action!")
      hero ! GetSerious()

    case End() =>
      log.info("That's it. Thank You!")
      context.system.shutdown()

  }

}
