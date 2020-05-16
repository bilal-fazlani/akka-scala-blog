package tech.bilal

import akka.actor.typed.ActorRef

sealed trait BankAccountMessage

case class Deposit(amount: Int)               extends BankAccountMessage
case class Withdraw(amount: Int)              extends BankAccountMessage
case class GetBalance(replyTo: ActorRef[Int]) extends BankAccountMessage
