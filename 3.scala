class Account(id:String, n:String, b:Double){
  val nic:String=id
  val acnumber: String = n
  var  balance: Double = b
  def withdraw(a:Double) = this.balance=this.balance-a
  def deposit(a:Double) = this.balance=this.balance+a
  def transfer(a: Account,b:Double): Unit ={
    this.withdraw(b)
    a.deposit(b)
  }
  override def toString ="["+nic+":"+acnumber +":"+ balance+"]"
}