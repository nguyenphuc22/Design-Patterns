# Decorator Pattern

## Khái niệm

**Decorator Pattern** thuôc nhóm cấu trúc (Structural Pattern). Cho phép người dùng thêm các hành vi mới cho một đối tượng, nhưng không thay đổi cấu trúc của đối tượng, bằng cách bọc đối tượng trong một lớp đặc biệt.

## Đặt vấn đề

Giả sự bạn có một lớp Notifer có chức năng là gửi thông báo về mail. Sau đó người dùng muốn có thêm tính năng gửi thông báo qua SMS, rồi có người lại muốn gửi thông báo quá Facebook, đối với doanh nghiệp họ loại muôn gửi Slack.

Bạn quyết định tạo thêm ba lớp và kế thừa từ lớp Notifier và bạn nghỉ mọi chuyện đã yên.

![](Images/Problem.png)

Sau một thời gian người dùng muốn có thêm các chức kết hợp dư. Ví dụ tui bị cháy nhà, tui muốn thông báo qua cả SMS,Facebook,Slack hoặc là nhiều sự kết hợp giữa 3 cái trên. Nếu như làm theo cách thì ứng dụng của bạn sẽ phình to ra như sau.

![](Images/Problem2.png)

Nếu cứ tiếp tục theo cách này. Sớm hay muộn ứng dụng của bạn cũng sẽ đạt một dãy Guinness. :smile:

## Giải pháp

Sử dụng Decorator sẽ giải quyết vấn đề này. Vấn đề chung ở chỗ là việc kế thừa, nó gây quá nhiều lớp tĩnh không tương thích được với nhau, vì vậy để làm mềm đi sự cứng ngắt này ta nên thêm Aggregation hoặc Composition

![](Images/Solution.png)

## Cấu Trúc
![](Images/struct.png)

- **Component**: là interface quy định các phương thức chung cần phải có cho các thành phần trong mẫu.
- **ConcreteComponent**: Triển khai (implements) các phương thức Component
- **Decorator**: Chủ yếu tạo ánh xạ (Liên kết) của đối tượng Component với ConcreteDecorator/
- **ConcreteDecorator**: Triển khai (Implements) các phương thức Decorator, thường là trang trí , thêm thắc các chức năng phụ, core chính là ConcreteComponent xử lý.

## Ví dụ áp dụng Decorator Pattern

Ta sẽ lấy ví dụ ở trên nên mình không giải thích nữa.

![](Images/Vidu.png)

Notifier.kt

```kotlin
interface Notifier {
    fun send(message : String)
}
```

NotifierConcrete.kt

```kotlin
class NotifierConcrete : Notifier {

    override fun send(message: String) {
        println(message)
    }

}
```

NotifierBaseDecoretor.kt

```kotlin
abstract class NotifierBaseDecorator : Notifier {

    var notifier : Notifier

    constructor(notifier: Notifier) {
        this.notifier = notifier
    }


    override fun send(message: String) {
        notifier.send(message)
    }
}
```

Notifier_FB.kt

```kotlin
class Notifier_FB : NotifierBaseDecorator {

    constructor(notifier: Notifier) : super(notifier)

    override fun send(message: String) {
        System.out.println("Thông báo từ Facebook")
        super.send(message)

    }

}
```

Notifier_Slack.kt

```kotlin
class Notifier_Slack : NotifierBaseDecorator {

    constructor(notifier: Notifier) : super(notifier)

    override fun send(message: String) {
        System.out.println("Thông báo từ Slack")
        super.send(message)
    }
}
```

Notifier_SMS.kt

```kotlin
class Notifier_SMS : NotifierBaseDecorator {

    constructor(notifier: Notifier) : super(notifier)

    override fun send(message: String) {
        System.out.println("Thông báo qua SMS")
        super.send(message)
    }
}
```

main.kt

```kotlin
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
```

Kết quả:

```
Thông báo từ Facebook

Cháy nhà rồi!
------------------------------------

Thông báo từ Slack

Cháy nhà rồi!
------------------------------------

Thông báo qua SMS

Cháy nhà rồi!
------------------------------------

Thông báo qua SMS
Thông báo từ Facebook
Thông báo từ Slack
Cháy nhà rồi!

Process finished with exit code 0
```

## Khi nào Áp dụng

Sử dụng khi bạn cần gán thêm các hành vi vào đối tượng mà không cần phải thay đổi đối tượng.

Sử dụng khi việc mở rộng bằng kế thừa quá khó, làm cho code bạn trở nên phức tạp.
