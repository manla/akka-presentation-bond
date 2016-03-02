package com.bond

import akka.actor.{Props, ActorSystem}

object Scenario extends App {

  // create the actor system
  val system = ActorSystem("BondEnsemble")

  // create the special agent
  val propsBond = Props[SpecialAgent]
  val bond = system.actorOf(propsBond, "Bond")

  // create two bad guys, trying to kill the special agent
  val propsBad = Villain.props(bond, 3)
  val bad = system.actorOf(propsBad, "Bad")
  val propsGuy = Villain.props(bond, 5)
  val guy = system.actorOf(propsGuy, "Guy")

  // last not least the regisseur...
  val regiProps = Regisseur.props(bond, 11, 16)
  val quentin = system.actorOf(regiProps, "Quentin")

  system.awaitTermination()

}
