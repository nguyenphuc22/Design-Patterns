# Command Pattern

## Khái niệm

**Command** là một Pattern dạng hành vi, cho phép biến một yêu cầu thành một đối tượng độc lập và chứa đầy đủ thông tin về yêu cầu đó. Nói cho dể hiểu, nó cho phép tất cả những Request gửi đến object được lưu trong chính object đó dưới dạng một object Command.

## Đặt vấn đề

Giả sử bạn đang làm trên một ứng dụng soạn thảo văn bản mới. Công việc của bạn hiện tại là tạo một thanh toolbar với vài nút button để chỉnh sữa. Giờ bạn tạo một lớp cơ sở `Button` để sử dụng cho các nút button trên toolbar.

Các nút button có vẻ rất giống nhau, nhưng sự kiện của từng nút thì lại khác nhau. Làm sao để gắn sự kiện cho từng nút button ? Cách đơn giản nhất là tạo các lớp riêng cho từng sự kiện và kế thừa lại lớp cơ sở `Button`

![](Images/problem.png)

Sau một thời gian, bạn nhận ra rằng cách tiếp cận này rất thiêu sót. Đầu tiên, bạn có rất nhiều lớp con, và điều này vẫn ổn nếu như không phá mã trong các lớp khi lớp cơ sỡ `Button` thay đổi.

Vấn đề tới nhất sẽ đến, khi ứng dụng của bạn phát triên cao hơn, người dùng không chỉ muốn nhấn vào các nút để thực hiện chức năng, mà còn  thực hiện thông qua phím tắt hoặc vài thao tác kéo thả. Như vậy bạn phải một lớp khác bắt sự kiến phím tắt, sau đó lại copy toàn bộ chức năng ở nút `button` đã implement. Điều khá tốt những khi có việc cần thay đổi chức năng bạn phải cập nhật ở nhiều nơi.

## Giải pháp

Để giải quyết vấn đề trên, ta sẽ tách phần giao diện và phần logic ra hai lớp khác nhau. Lớp GUI (Giao Diện) sẽ đảm nhiệm vài trò thể hiện các giao diện đẹp ra cho người dùng sử dung, đồng thời sẽ lắng nghe và bắt các sự khi người dùng sử dụng. Tuy nhiên, khi cần đến những việc tính toán, lưu trữ dữ liệu, hoặc truy vấn dữ liệu thì phần GUI nên giao lại cho phần logic đảm nhiệm.

Nói đến đây các bạn sẽ nghỉ chỉ cần tách ra một lớp logic bắt và xử lý các logic các sử kiện nút `Button` thì đã xong.

![](Images/solution.png)

Nhưng với Command Pattern đề nghị bạn đừng nên dùng GUI gọi yêu cầu trực tiếp. Bạn nên trích các thông tin, yêu cầu , tên phương được gọi......vào một lớp đặc biệt cùng với một phương thức để kích hoạt yêu cầu.

![](Images/solution2.png)

Như vậy ta sẽ giảm được sử ghép nối giữa GUI và Logic, giúp bạn có thể Linh hoạt hơn trong sử dụng

## Cấu Trúc

![](Images/struct.png)

- **Command**: là interface hoặc abstract class, chứa một phương thức duy nhất để executing lệnh.
- **Concrete Command**: Thực hiện các yêu cầu khác nhau. Một Concrete Command không phải tự mình thực hiện công việc, thường sẽ chuyển đến lớp logic chuyên nghiệp.
- **Client**: Tiếp nhận request từ phía người dùng, đống gói request thành ConcreteCommand thích hợp.
- **Invoker**: Tiếp nhận Concrete Command từ Client và gọi execute()
- **Receiver**: Đây là thành phần thực thi logic chuyên nghiệp.

## Ví dụ áp dụng Command Pattern

![](Images/vidu.png)

Account.kt

```kotlin
class Account {
    var name : String

    constructor(name: String) {
        this.name = name
    }

    fun open() {
        println("Account $name Opened")
    }

    fun close() {
        println("Account $name Closed")
    }

}
```

Command.kt

```kotlin
interface Command {
    fun execute()
}
```

OpenAccount.kt

```kotlin
class OpenAccount : Command{
    var account: Account

    constructor(account: Account) {
        this.account = account
    }

    override fun execute() {
        account.open()
    }
}
```

CloseAccount.kt

```kotlin
class CloseAccount : Command {
    var account: Account

    constructor(account: Account) {
        this.account = account
    }


    override fun execute() {
        account.close()
    }
}
```

BankApp.kt

```kotlin
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
```

main.kt

```kotlin
fun main(args: Array<String>) {
    var account : Account = Account("NickSeven")

    var openAccount : Command = OpenAccount(account)

    var closeAccount : Command = CloseAccount(account)

    var bankApp : BankApp = BankApp(openAccount,closeAccount)

    bankApp.clickOpenAccount()

    bankApp.clickCloseAccount()
}
```

Kết quả

```
User click open an account
Account NickSeven Opened
User click close an account
Account NickSeven Closed

Process finished with exit code 0
```

## Khi nào áp dụng

Khi cần tham số hóa các đối tượng theo một hành động thực hiện.

Khi cần tạo và thực thi các yêu cầu vào các thời điểm khác nhau.