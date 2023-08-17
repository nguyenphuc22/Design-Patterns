class BankApp {
    private var openAccount: Command? = null
    private var closeAccount: Command? = null

    constructor(openAccount: Command?, closeAccount: Command?) {
        this.openAccount = openAccount
        this.closeAccount = closeAccount
    }


    fun clickOpenAccount() {
        println("User click open an account")
        openAccount!!.execute()
    }

    fun clickCloseAccount() {
        println("User click close an account")
        closeAccount!!.execute()
    }
}