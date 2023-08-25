import java.io.File
import java.io.FileWriter

fun main(args: Array<String>) {
    mainFlow()
}
fun mainFlow(): Unit{
    mainFlowEntity()

    val folder = File("accounts")
    if (!folder.exists()) {
        folder.mkdir()
    } else {
    }

    var option: Int = readLine()!!.toInt()
    when(option){
        1 -> transaction()
        2 -> createAccount()
        3 -> deleteAccount()
        4 -> checkDetail()
        5 -> updateInformation()
        6 -> return
        else -> mainFlow()
    }
}

fun mainFlowEntity(): Unit{
    println("\n\nEnter Option")
    println("1 - Transaction")
    println("2 - Create Account")
    println("3 - Delete Account")
    println("4 - Check Detail")
    println("5 - Update Information")
    println("6 - Exit")
}

fun transaction(): Unit{
    println("Enter Your Operation")
    println("1 - Credit")
    println("2 - Debit")
    var option: Int = readLine()!!.toInt()
    when(option){
        1 -> credit()
        2 -> debit()
        else -> mainFlow()
    }
}
fun credit(): Unit{
    print("Enter Your Account Number : ")
    var accountNo: String = readLine()!!
    val balance = File("accounts/"+accountNo+"/balance.txt")
    if(balance.exists()){
        val balanceF = balance.readText()
        var currBalance = balanceF.toInt()
        println("Your Current Balance is ${currBalance}")
        print("Enter amount : ")
        var amount: Int = readLine()!!.toInt()
        currBalance = amount + currBalance
        val updatedBalance = "accounts/"+accountNo+"/balance.txt"
        val fileName3 = FileWriter(updatedBalance)
        fileName3.write(currBalance.toString())
        fileName3.close()
        println("Your Updated Balance is ${currBalance}")
    }
    else{
     print("Account Does Not Exist")
    }
    mainFlow()
}
fun debit(): Unit{
    print("Enter Your Account Number : ")
    var accountNo: String = readLine()!!
    val balance = File("accounts/"+accountNo+"/balance.txt")
    if(balance.exists()){
        val balanceF = balance.readText()
        var currBalance = balanceF.toInt()
        println("Your Current Balance is ${currBalance}")
        print("Enter amount : ")
        var amount: Int = readLine()!!.toInt()
        if(currBalance < amount){
            println("This transaction not performed because of unsufficient balance")
            mainFlow()
            return
        }
        currBalance = currBalance - amount
        val updatedBalance = "accounts/"+accountNo+"/balance.txt"
        val fileName3 = FileWriter(updatedBalance)
        fileName3.write(currBalance.toString())
        fileName3.close()
        println("Your Updated Balance is ${currBalance}")
    }
    else{
        print("Account Does Not Exist")
    }
    mainFlow()
}

fun createAccount(): Unit{
    print("Enter Your Name : ")
    var name = readLine()
    print("Enter Your Account Number : ")
    var accountN = readLine()
    print("Enter Your Phone Number : ")
    var phone = readLine()
    print("Enter your address : ")
    var address = readLine()

    val folder = File("accounts/"+accountN)
    if (!folder.exists()) {
        folder.mkdir()
    } else {
    }


    val nameF = "accounts/"+accountN+"/name.txt"
    val file = File(nameF)
    file.createNewFile()
    val fileName = FileWriter(nameF)
    fileName.write(name)
    fileName.close()

    val addressF = "accounts/"+accountN+"/address.txt"
    val file1 = File(addressF)
    file1.createNewFile()
    val fileName1 = FileWriter(addressF)
    fileName1.write(address)
    fileName1.close()

    val balanceF = "accounts/"+accountN+"/balance.txt"
    val file2 = File(balanceF)
    file2.createNewFile()
    val fileName2 = FileWriter(balanceF)
    fileName2.write("100")
    fileName2.close()


    val phoneF = "accounts/"+accountN+"/phone.txt"
    val file3 = File(phoneF)
    file3.createNewFile()
    val fileName3 = FileWriter(phoneF)
    fileName3.write(phone)
    fileName3.close()

    mainFlow()

}


fun deleteAccount(): Unit{
    println("Enter a account number that you want to delete")
    var accountNo = readLine()!!.toInt();

    val name = File("accounts/"+accountNo+"/name.txt")
    val address = File("accounts/"+accountNo+"/address.txt")
    val phone = File("accounts/"+accountNo+"/phone.txt")
    val balance = File("accounts/"+accountNo+"/balance.txt")
    if(name.exists()) {
        name.delete()
        address.delete()
        phone.delete()
        balance.delete()

        val folder = File("accounts/" + accountNo)
        folder.deleteRecursively()
        println("Account Delete Sucefully !!")
    }
    else{
        println("Account does not exist !!")
    }
    mainFlow()

}

fun checkDetail(): Unit{
    print("Enter Your Account Number : ")
    var accountNo = readLine()
    val name = File("accounts/"+accountNo+"/name.txt")
    val nameF = name.readText()
    val balance = File("accounts/"+accountNo+"/balance.txt")
    val balanceF = balance.readText()
    val address = File("accounts/"+accountNo+"/address.txt")
    val addressF = address.readText()
    val phone = File("accounts/"+accountNo+"/phone.txt")
    val phoneF = phone.readText()

    println("Name    : ${nameF}")
    println("Balance : ${balanceF}")
    println("Address : ${addressF}")
    println("Phone   : ${phoneF}")
    mainFlow()
}

fun updateInformation(): Unit{

}