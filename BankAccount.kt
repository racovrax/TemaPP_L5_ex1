package ro.mike.tuiasi
import java.time.LocalDate
import java.util.Date

typealias Date = LocalDate
class BankAccount(
    private var availableAmount: Double,
    private var cardNumber: String,
    private var cvvCode: Int,
    private var userName: String){

    fun updateAmount(value:Double):Boolean{
        if(value>availableAmount){
            return false
        }
        availableAmount= availableAmount - value
        return true
    }
}