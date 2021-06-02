# Facade

## Khái niệm

Facede Pattern là một Pattern thuộc nhóm cấu trúc (Structural Pattern). Pattern này cung cấp một giao diện chung đơn giản để kết nối một library, framework hoặc một lớp nào đó rất phức tạp.

## Đặt vấn đề

Hãy tưởng tượng bạn sử dụng một thư viện của bên thứ ba. Mọi chuyện sẽ không có gì cho đến khi bạn làm việc với một loạt các đối tượng trong thư viện và chúng liên kết với nhau rất phức tạp và có tuần tự khởi tạo.

Kết quả, khi đã kết hợp code của mình và thư viện thành công, thì code của ứng dụng của bạn trở nên phức tạp, khó mở rộng và bảo trì.

## Giái pháp

Facade Pattern sẽ giúp bạn trọng việc này, pattern này sẽ giúp bạn liên kết với nhiều đối tượng trong thư viện thứ ba và chỉ cung cấp cho bạn các interface đơn giản để sử dụng. Lưu ý, pattern này chỉ cung cấp một số chức năng mà người dùng thật sự  cần.

## Cấu Trúc

![](Images\Struct%20Diagram.png)

- Facede: Phân phối yêu của Client đến các Subsystems đảm nhận công việc.
- Subsystems: cài đặt các phương thức của mình và implement Facede.
- Client: người sử dụng Facade để tương tác với subsystem.

## Ví dụ áp dụng Facede

![](Images\Vidu%20Diagram.png)

LoginService.java

```java
public class LoginService {

    public void loginFB(String userName) {
        System.out.println(userName + "Login Facebook");
    }

    public void loginYoutube(String userName) {
        System.out.println(userName + "Login Youtube");
    }

    public void loginGithub(String userName) {
        System.out.println(userName + "Login Github");
    }
}
```

PayService.java

```java
public class PayService {

    public void payByPayPal() {
        System.out.println("Pay by PayPal");
    }

    public void payByMoMo() {
        System.out.println("Pay by MoMo");
    }

    public void payByDebitCash() {
        System.out.println("Pay by Debit Cash");
    }

}
```

ShipService.java

```java
public class ShipService {

    public void nowShip()
    {
        System.out.println("Now Ship");
    }

    public void grabShip()
    {
        System.out.println("Grab Ship");
    }

    public void ninjaVanShip()
    {
        System.out.println("Ninja Van Ship");
    }

}
```

NotiService.java

```java
public class NotiService {

    public void NotificationSMS() {
        System.out.println("Notification SMS");
    }

    public void NotificationGmail() {
        System.out.println("Notification Gmail");
    }

}
```

ShopFacade.java

```java
public class ShopFacade {

    private LoginService loginService;
    private PayService payService;
    private ShipService shipService;
    private NotiService notiService;

    public ShopFacade() {
        this.loginService = new LoginService();
        this.payService = new PayService();
        this.shipService = new ShipService();
        this.notiService = new NotiService();
    }

    public void buyProductByMoMoWithGrabShipping(String name) {
        loginService.loginFB(name);
        payService.payByMoMo();
        shipService.grabShip();
        notiService.NotificationSMS();
    }

    public void buyProductByPayPalWithNinjaVanShipping(String name) {
        loginService.loginGithub(name);
        payService.payByPayPal();
        shipService.ninjaVanShip();
        notiService.NotificationGmail();
    }
}
```

Demo.java

```java
public class Demo {
    public static void main(String[] args) {
        ShopFacade shopFacade = new ShopFacade();
        shopFacade.buyProductByMoMoWithGrabShipping("Nick");
        System.out.println();
        shopFacade.buyProductByPayPalWithNinjaVanShipping("Nick");
    }
}
```

Kết quả

```
NickLogin Facebook
Pay by MoMo
Grab Ship
Notification SMS

NickLogin Github
Pay by PayPal
Ninja Van Ship
Notification Gmail

Process finished with exit code 0

## Khi nào áp dụng
```

## Khi nào áp dụng

Sử dụng khi bạn muốn có một interface đơn giản để sử dụng một chức năng phức tạo nào đó của thư viện

Khi bạn muốn phân lớp cá hệ thống con.

