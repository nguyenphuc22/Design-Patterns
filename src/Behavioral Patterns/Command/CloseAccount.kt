class CloseAccount : Command {
    var account: Account

    constructor(account: Account) {
        this.account = account
    }


    override fun execute() {
        account.close()
    }
}