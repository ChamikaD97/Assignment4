object Bank extends App {

  class Account(NICnum: String, AccountNumber: Int, AccountBalance: Double) {
    val NIC: String = NICnum
    val AccountNo: Int = AccountNumber
    var Balance: Double = AccountBalance

    override def toString: String = "[" + NIC + ":" + AccountNo + ":" + Balance + "]"

    def withdraw(amount: Double): Unit = this.Balance -= amount

    def deposit(amount: Double): Unit = this.Balance += amount

    def transfer(account: Account, amount: Double): Unit = {
      this.withdraw(amount)
      account.deposit(amount)
    }
  }

  var Account1 = new Account(NICnum = "971111111V", AccountNumber = 1152, AccountBalance = 2500)
  var Account2 = new Account(NICnum = "982222222V", AccountNumber = 1162, AccountBalance = -700)
  var Account3 = new Account(NICnum = "993333333V", AccountNumber = 1172, AccountBalance = 1950)
  var Account4 = new Account(NICnum = "934444444V", AccountNumber = 1182, AccountBalance = -500)
  

  val bank: List[Account] = List[Account](Account1, Account2,Account3,Account4)

  val find = (NICnum: String, bank: List[Account]) => bank.filter(AC => AC.NIC.equals(NICnum))
  
  val overdraft = (bank: List[Account]) => bank.filter(AC => AC.Balance < 0)
  
  val totalBalance = (bank: List[Account]) => bank.reduce((AC1, AC2) => new Account("", 0, AC1.Balance + AC2.Balance)).Balance
  
  val interest = (bank: List[Account]) => bank.map(AC => if (AC.Balance >= 0) AC.Balance * 1.05 else AC.Balance * 1.1)
  
  val balanceWithInterest = (interests: List[Double]) => interests.reduce((interest1, interest2) => interest1 + interest2)


  println("Accounts with negative balances :" + overdraft(bank).toString())
  println("Sum of all account balances :" + totalBalance(bank))
  println("Final balances of all accounts after apply the interest function :" + balanceWithInterest(interest(bank)))
}