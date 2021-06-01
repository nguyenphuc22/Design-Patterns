class Notifier_FB : NotifierBaseDecorator {

    constructor(notifier: Notifier) : super(notifier)

    override fun send(message: String) {
        System.out.println("Thông báo từ Facebook")
        super.send(message)

    }

}