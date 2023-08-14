# Bridge Pattern

## Khái niệm

Bride là một Pattern thuộc nhóm cấu trúc. Nó tách một lớp lớn hoặc các lớp có quan hệ chặt chẽ với nhau thành các phần có thể phát triển một cách độc lập.

## Đặt vấn đề

Giả sử, bạn có một lớp `vehicle` với hai lớp phụ (subclass): `BicycleBike` và `MotorBike`. Bạn muốn mở rộng thêm phương tiện có thêm màu sắc và bạn thêm thuộc tính `Red` và `Blue`. Cách này vẫn chạy được, nhưng bạn phải tạo đến bốn lớp (Class) cho sự kết hợp như `BlueBicycleBike` and `RedMotorBike`

![](Images/Problem%20Diagram-Page-2.png)

Với mô hình này, khi thêm mới một phương tiện hoặc màu sắc mới bạn buộc phải tạo thêm đầy đủ các thuộc tính. Điều này làm cho tôn thời gian và khó kiểm soát.

## Giải pháp

Mấu chốt của vấn đề là ta đang cố gắng nhét quá nhiều thứ vào lớp abstract, mà các thứ trên lại phát triển theo hướng khác nhau.
![](Images/Solution%20Diagram-Page-3.png)

Mẫu Bridge Pattern sẽ giải quyết vấn đề này bằng cách tách chia nhỏ đối tượng abstract và các đối tượng, sau đó liên kết hai abstract lại. Trong trường hợp này phương tiện sẽ có màu sắc, vì thế là quan hệ has-a

## Cấu Trúc
![](Images/Struct%20Diagram.png)

- The Abstraction:  cung cấp mức quản lý cấp cao, nhầm để quản lý các công việc do các đối tượng cụ thể thực hiện (Implementation)
- The Implementation:  Định ra các interface cho các đối tượng khác thực hiện. Thông thường nó là interface định ra các tác vụ nào đó của abstraction.
- Concrete Implementations: chứa các logic riêng và implement các tác vụ do implementation định ra.
- Refined Abstractions: Thực hiện các implement phương thức định ra trong Abstraction.

## Ví dụ áp dụng Bridge Pattern

![](Images/Untitled%20Diagram.png )



Account.java

```java
public interface Account {
    void openAccount();
}
```

CheckingAccount.java

```java
public class CheckingAccount implements Account{
    @Override
    public void openAccount() {
        System.out.println("Checking Account!");
    }
}
```

TutorialAccount.java

```java
public class TutorialAccount implements Account{
    @Override
    public void openAccount() {
        System.out.println("Xin vui lòng chọn ngôn ngữ");
        System.out.println("Please select your language");
    }
}
```

Bank.java

```java
public abstract class Bank {
    protected Account account;

    public Bank(Account account) {
        this.account = account;
    }

    public abstract void openAccount();
}
```

MMBank.java

```java
public class MMBank extends Bank {

    public MMBank(Account account) {
        super(account);
    }

    @Override
    public void openAccount() {
        System.out.println("Chào mừng đến với MBBank");
        System.out.println("Welcome to MMBank");
        account.openAccount();
    }
}
```

TPBank.java

```java
public class TPBank extends Bank {

    public TPBank(Account account) {
        super(account);
    }

    @Override
    public void openAccount() {
        System.out.println("Chào mừng đến với TPBank");
        System.out.println("Welcome to TPBank");
        this.account.openAccount();
    }
}
```

demo.java

```java
public class demo {
    public static void main(String[] args) {
        Bank bank = new TPBank(new TutorialAccount());
        bank.openAccount();
        System.out.println();
        bank = new TPBank(new CheckingAccount());
        bank.openAccount();
        System.out.println();
        bank = new MMBank(new TutorialAccount());
        bank.openAccount();
    }
}
```

Kết quả:

```
Chào mừng đến với TPBank
Welcome to TPBank
Xin vui lòng chọn ngôn ngữ
Please select your language

Chào mừng đến với TPBank
Welcome to TPBank
Checking Account!

Chào mừng đến với MBBank
Welcome to MMBank
Xin vui lòng chọn ngôn ngữ
Please select your language
```

