abstract class NotifierBaseDecorator : Notifier {

    var notifier : Notifier

    constructor(notifier: Notifier) {
        this.notifier = notifier
    }


    override fun send(message: String) {
        notifier.send(message)
    }
}