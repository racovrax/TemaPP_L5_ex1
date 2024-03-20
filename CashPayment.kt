package ro.mike.tuiasi

import jdk.jfr.DataAmount

class CashPayment(var availableAmount: Double):PaymentMethod {
    override fun pay(fee:Double):Boolean{
        if(availableAmount>=fee){
            availableAmount= availableAmount-fee
            return true
        }
        return false
    }
}