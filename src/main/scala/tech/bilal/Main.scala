package tech.bilal

import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.{ActorRef, ActorSystem, Behavior}

object Main extends App {

  def behavior(balance: Int): Behavior[BankAccountMessage] = Behaviors.receiveMessage {
    case Deposit(amount)  => behavior(balance + amount)
    case Withdraw(amount) => behavior(balance - amount)
    case PrintBalance =>
      println(s"balance = $balance")
      behavior(balance)
  }

  val actorSystem                            = ActorSystem(Behaviors.empty, name = "MyBankActorSystem")
  val account1: ActorRef[BankAccountMessage] = actorSystem.systemActorOf(behavior(balance = 0), "account1")
  println(account1)

  account1 ! PrintBalance
  account1 ! Deposit(200)
  account1 ! Withdraw(50)
  account1 ! PrintBalance

  actorSystem.terminate()
}
