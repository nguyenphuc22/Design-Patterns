fun main(args: Array<String>) {
    var account : Account = Account("NickSeven")

    var openAccount : Command = OpenAccount(account)

    var closeAccount : Command = CloseAccount(account)

    var bankApp : BankApp = BankApp(openAccount,closeAccount)

    bankApp.clickOpenAccount()

    bankApp.clickCloseAccount()
}