package ro.mike.tuiasi

class CardPayment(val bankAccount: BankAccount):PaymentMethod{
    override fun pay(fee: Double):Boolean{
        return bankAccount.updateAmount(fee)
    }
}