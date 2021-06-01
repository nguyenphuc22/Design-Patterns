class Notifier_SMS : NotifierBaseDecorator {

    constructor(notifier: Notifier) : super(notifier)

    override fun send(message: String) {
        System.out.println("Thông báo qua SMS")
        super.send(message)
    }
}