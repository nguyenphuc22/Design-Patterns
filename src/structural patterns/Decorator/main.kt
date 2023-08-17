fun main(args: Array<String>) {
    var message : String = "Cháy nhà rồi!"

    var facebook = Notifier_FB(NotifierConcrete())
    facebook.send(message)
    System.out.println("------------------------------------")

    var slack = Notifier_Slack(NotifierConcrete())
    slack.send(message)
    System.out.println("------------------------------------")

    var sms = Notifier_SMS(NotifierConcrete())
    sms.send(message)
    System.out.println("------------------------------------")

    var sms_fb_slack = Notifier_SMS(Notifier_FB(Notifier_Slack(NotifierConcrete())))
    sms_fb_slack.send(message)

}