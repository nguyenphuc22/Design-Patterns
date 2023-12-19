# Command

## Khái Niệm

**Command** trong phát triển phần mềm, đóng vai trò như một mẫu thiết kế hành vi, giúp chuyển đổi một yêu cầu thành một đối tượng độc lập chứa đầy đủ thông tin về yêu cầu đó. Cách tiếp cận này tạo ra một cấu trúc cho phép các yêu cầu được gửi, xử lý, và lưu trữ dưới dạng các đối tượng Command. Điều này cung cấp sự linh hoạt cao trong việc quản lý yêu cầu, cũng như trong việc thực thi các hành động phức tạp.

### Tổng quan

- **Định Nghĩa của Pattern:** Command Pattern cho phép đóng gói thông tin cần thiết để thực hiện một hành động hoặc kích hoạt một sự kiện vào trong một đối tượng đơn lẻ. Điều này bao gồm thông tin về phương thức nào được gọi, người gọi, và các tham số của phương thức.

- **Mục Đích:** Mục đích chính của mẫu thiết kế này là tách rời người phát ra yêu cầu (sender) khỏi đối tượng thực hiện yêu cầu (receiver). Điều này giúp giảm sự phụ thuộc giữa các lớp gọi và lớp nhận, từ đó tăng tính mô-đun và khả năng mở rộng của ứng dụng.

- **Ý Tưởng Cốt Lõi:** Trong Command Pattern, mỗi yêu cầu hoặc hành động được đóng gói thành một đối tượng Command riêng biệt. Điều này cho phép lưu trữ, xếp hàng, và kiểm soát các yêu cầu một cách linh hoạt. Nó cũng hỗ trợ hoạt động hoãn hành, undo/redo, hoặc ghi nhật ký các thao tác.

## Đặt vấn đề

Giả sử bạn đang làm việc trên một ứng dụng soạn thảo văn bản mới. Công việc hiện tại của bạn là tạo một thanh công cụ (toolbar) với vài nút (button) để chỉnh sửa. Bạn bắt đầu bằng cách tạo một lớp cơ sở `Button` để sử dụng cho các nút trên toolbar.

Các nút này có vẻ rất giống nhau, nhưng sự kiện xử lý của mỗi nút lại khác biệt. Làm sao để gán sự kiện cho mỗi nút button? Cách đơn giản nhất là tạo các lớp riêng biệt cho từng sự kiện và kế thừa lớp cơ sở `Button`.

Sau một thời gian, bạn nhận ra rằng phương pháp này có nhiều hạn chế. Đầu tiên, sự gia tăng của lớp con khiến kiến trúc trở nên phức tạp. Hơn nữa, mỗi khi lớp cơ sở `Button` thay đổi, việc bảo trì mã nguồn trở nên khó khăn.

```mermaid
classDiagram
class Toolbar {
+addButton(button)
}
class Button {
+onClick()
}
class TextEditButton {
+onClick()
}
class FontSizeButton {
+onClick()
}
class ShortcutHandler {
+handleShortcut()
}

Toolbar o-- Button : contains
Button <|-- TextEditButton : extends
Button <|-- FontSizeButton : extends
Toolbar o-- ShortcutHandler : uses

class TextEditButton {
+executeTextEdit()
}
class FontSizeButton {
+executeFontSizeChange()
}
ShortcutHandler ..> TextEditButton : calls
ShortcutHandler ..> FontSizeButton : calls
```

Vấn đề trở nên nghiêm trọng hơn khi ứng dụng phát triển: người dùng không chỉ muốn thao tác thông qua các nút mà còn muốn sử dụng phím tắt hoặc các thao tác kéo thả. Điều này đòi hỏi bạn phải tạo thêm lớp để xử lý sự kiện từ phím tắt, và sau đó, phải sao chép toàn bộ chức năng đã được triển khai trong các nút button. Điều này không những tốn công mà còn gây khó khăn khi cần cập nhật chức năng, vì bạn phải thực hiện thay đổi ở nhiều nơi.

## Giải pháp

```mermaid
classDiagram
    class GUI {
        +Hiển thị giao diện
        +Lắng nghe tương tác người dùng
        +Chuyển giao tác vụ
    }
    class Logic {
        +Xử lý tính toán
        +Lưu trữ dữ liệu
        +Truy vấn dữ liệu
    }
    class Command {
        +Thông tin yêu cầu
        +Tên phương thức
        +Kích hoạt yêu cầu
    }

    GUI "1" --o "1" Command : Triggers
    Command "1" --o "1" Logic : Executes

    GUI : -Gửi yêu cầu thông qua Command
    Logic : -Thực hiện các tác vụ nặng
    Command : -Giảm liên kết GUI-Logic
```


Để giải quyết vấn đề này, chúng ta cần phân tách giao diện người dùng và logic nền tảng thành hai lớp riêng biệt. Lớp GUI (Giao Diện Người Dùng) chịu trách nhiệm hiển thị giao diện trực quan và thân thiện cho người dùng, đồng thời lắng nghe và phản ứng với các tương tác từ phía người dùng. Tuy nhiên, khi đến phần xử lý tính toán, lưu trữ, và truy vấn dữ liệu, thì lớp GUI nên chuyển giao nhiệm vụ này cho lớp logic.

Có thể bạn sẽ nghĩ chỉ cần tạo ra một lớp logic để nhận và xử lý các sự kiện từ nút `Button` là đủ. Tuy nhiên, theo Command Pattern, tôi khuyến nghị không nên để GUI gọi trực tiếp các yêu cầu. Thay vào đó, bạn nên tạo một lớp đặc biệt, trong đó chứa thông tin và yêu cầu cần thiết, cùng với tên phương thức sẽ được gọi và một phương thức để kích hoạt yêu cầu đó.

Nhờ cách làm này, sự liên kết chặt chẽ giữa GUI và Logic sẽ được giảm bớt, giúp bạn có thêm sự linh hoạt trong quá trình sử dụng và phát triển phần mềm.

## Cấu Trúc

- **Command**: là interface hoặc abstract class, chứa một phương thức duy nhất để executing lệnh.
- **Concrete Command**: Thực hiện các yêu cầu khác nhau. Một Concrete Command không phải tự mình thực hiện công việc, thường sẽ chuyển đến lớp logic chuyên nghiệp.
- **Client**: Tiếp nhận request từ phía người dùng, đống gói request thành ConcreteCommand thích hợp.
- **Invoker**: Tiếp nhận Concrete Command từ Client và gọi execute()
- **Receiver**: Đây là thành phần thực thi logic chuyên nghiệp.

## Ví dụ áp dụng Command Pattern

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
