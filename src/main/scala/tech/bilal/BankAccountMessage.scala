package tech.bilal

sealed trait BankAccountMessage

case class Deposit(amount: Int)  extends BankAccountMessage
case class Withdraw(amount: Int) extends BankAccountMessage
case object PrintBalance         extends BankAccountMessage
