class Notifier_Slack : NotifierBaseDecorator {

    constructor(notifier: Notifier) : super(notifier)

    override fun send(message: String) {
        System.out.println("Thông báo từ Slack")
        super.send(message)
    }
}