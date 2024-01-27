# Memento

## Khái Niệm

**Memento Pattern**, trong lĩnh vực phát triển phần mềm, là một mẫu thiết kế hành vi. Nó được sử dụng để lưu trữ trạng thái của một đối tượng (được gọi là 'memento') mà không vi phạm tính đóng gói, cho phép đối tượng quay lại trạng thái trước đó mà không cần phụ thuộc vào các lớp khác. Memento Pattern cung cấp khả năng 'undo' hoặc 'rollback' trong các ứng dụng, mà không làm lộ chi tiết triển khai nội bộ của đối tượng.

### Tổng quan

- **Định Nghĩa của Pattern:** Memento Pattern bao gồm việc lưu trữ bản sao của trạng thái nội bộ của một đối tượng vào một đối tượng khác mà không làm lộ thông tin nội bộ. Điều này cho phép khôi phục trạng thái trước đó của đối tượng mà không vi phạm nguyên tắc đóng gói.

- **Mục Đích:** Mục đích chính của Memento Pattern là cho phép đối tượng quay lại trạng thái trước đó mà không cần phải lưu trữ thông tin nội bộ của đối tượng ra bên ngoài. Điều này giúp tăng tính bảo mật và độc lập của đối tượng, đồng thời cung cấp chức năng 'undo' mà không làm ảnh hưởng tới kiến trúc tổng thể của hệ thống.

- **Ý Tưởng Cốt Lõi:** Trong Memento Pattern, có ba thành phần chính: 'Originator' (tạo ra trạng thái để lưu), 'Memento' (lưu trữ trạng thái của 'Originator'), và 'Caretaker' (quản lý 'Memento' mà không cần biết chi tiết bên trong). 'Caretaker' yêu cầu lưu trạng thái từ 'Originator' và có thể yêu cầu 'Originator' quay lại trạng thái đã lưu trước đó, nhờ vào 'Memento'.

### Đặt vấn đề

Trong phát triển phần mềm, một vấn đề phổ biến đối với các ứng dụng cần quản lý trạng thái của đối tượng là việc lưu giữ và khôi phục các trạng thái trước đó. Xét tình huống của một trình soạn thảo văn bản: người dùng muốn có khả năng quay lại các phiên bản trước đó của tài liệu sau khi thực hiện một loạt thay đổi. Một cách tiếp cận đơn giản là lưu trữ mỗi trạng thái của tài liệu trong một cấu trúc dữ liệu riêng biệt. Tuy nhiên, cách tiếp cận này không hiệu quả về mặt bộ nhớ và có thể dẫn đến vi phạm nguyên tắc đóng gói, vì nó yêu cầu tiết lộ chi tiết nội bộ của tài liệu.

```mermaid
classDiagram
    class TextEditor {
      -currentDocumentState: DocumentState
      -previousStates: list
      +editDocument(newContent: String): void
      +undoEdit(): void
    }
    class DocumentState {
      -content: String
    }

    TextEditor "1" --o DocumentState : current state >
    TextEditor "1" -- "*" DocumentState : stores previous states >
```

### Giải quyết

Memento Pattern đưa ra một giải pháp hiệu quả cho vấn đề này. Pattern cho phép lưu giữ trạng thái của một đối tượng (còn gọi là "Originator") mà không vi phạm nguyên tắc đóng gói của nó. Điều này được thực hiện thông qua việc tạo ra một đối tượng "Memento", chứa trạng thái lưu trữ của "Originator". "Caretaker", một đối tượng khác, quản lý và lưu trữ các "Memento" mà không cần biết đến chi tiết bên trong của chúng. Khi cần khôi phục trạng thái cũ, "Originator" sẽ sử dụng đối tượng "Memento" tương ứng.

```mermaid
classDiagram
    class TextEditor {
      -documentState: String
      +setDocumentState(state: String): void
      +getDocumentState(): String
      +saveToMemento(): DocumentMemento
      +restoreFromMemento(memento: DocumentMemento): void
    }
    class DocumentMemento {
      -documentState: String
      +getDocumentState(): String
    }
    class History {
      -mementos: list
      +addMemento(memento: DocumentMemento): void
      +getMemento(index: int): DocumentMemento
    }

    TextEditor --o DocumentMemento : creates >
    History "1" -- "*" DocumentMemento : stores
```

Sử dụng Memento Pattern mang lại nhiều lợi ích. Nó giúp duy trì nguyên tắc đóng gói, vì trạng thái nội bộ của đối tượng được lưu trữ mà không cần tiết lộ thông qua giao diện công khai. Điều này cũng giúp tăng cường tính modular của ứng dụng, vì "Caretaker" có thể lưu trữ và quản lý nhiều "Memento" mà không cần biết đến logic nội bộ của "Originator". Hơn nữa, pattern này cung cấp một cách linh hoạt để lưu trữ lịch sử trạng thái của đối tượng mà không cần sao chép toàn bộ trạng thái mỗi lần.

Tuy nhiên, việc sử dụng Memento Pattern không phải không có nhược điểm. Việc lưu trữ nhiều bản sao của trạng thái đối tượng có thể chiếm dụng một lượng lớn bộ nhớ, đặc biệt là đối với các ứng dụng với trạng thái đối tượng phức tạp và lớn. Ngoài ra, việc quản lý các "Memento" có thể trở nên phức tạp, đặc biệt nếu cần hỗ trợ các hoạt động như undo/redo với nhiều cấp độ.

## Cấu trúc

```mermaid
classDiagram
    class Originator {
      -state: String
      +setState(state: String): void
      +getState(): String
      +saveToMemento(): Memento
      +restoreFromMemento(memento: Memento): void
    }
    class Memento {
      -state: String
      +getState(): String
    }
    class Caretaker {
      -mementos: list
      +addMemento(memento: Memento): void
      +getMemento(index: int): Memento
    }

    Originator --o Memento : creates >
    Caretaker "1" -- "*" Memento : stores
```


1. **Originator**: Lớp này chứa trạng thái cần được lưu trữ. Nó tạo ra một memento chứa một bản sao của trạng thái hiện tại và cũng có thể sử dụng memento để khôi phục trạng thái trước đó.

2. **Memento**: Lớp này chứa trạng thái của Originator. Nó bảo vệ thông tin trạng thái khỏi sự truy cập từ các đối tượng khác ngoại trừ Originator.

3. **Caretaker**: Lớp này quản lý memento nhưng không sửa đổi hoặc kiểm tra nội dung của memento.


## Cách triển khai

1. **Tạo Memento Class:** Đây là class sẽ chứa trạng thái của đối tượng.

```java
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
```

2. **Tạo Originator Class:** Đây là class mà trạng thái của nó sẽ được lưu và khôi phục.

```java
public class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
    }
}
```

3. **Tạo Caretaker Class:** Đây là class sẽ chứa và quản lý Memento, nhưng không thay đổi hoặc truy cập trực tiếp vào trạng thái lưu trữ.

```java
import java.util.ArrayList;
import java.util.List;

public class Caretaker {
    private List<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento state){
        mementoList.add(state);
    }

    public Memento get(int index){
        return mementoList.get(index);
    }
}
```

4. **Sử dụng Pattern:** Tạo các đối tượng và sử dụng Memento Pattern để lưu và khôi phục trạng thái.

```java
public class MementoPatternDemo {
    public static void main(String[] args) {
      
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();
        
        originator.setState("State #1");
        originator.setState("State #2");
        caretaker.add(originator.saveStateToMemento());
        
        originator.setState("State #3");
        caretaker.add(originator.saveStateToMemento());
        
        originator.setState("State #4");
        System.out.println("Current State: " + originator.getState());        
        
        originator.getStateFromMemento(caretaker.get(0));
        System.out.println("First saved State: " + originator.getState());
        originator.getStateFromMemento(caretaker.get(1));
        System.out.println("Second saved State: " + originator.getState());
    }
}
```

Trong đoạn code trên, bạn có thể thấy cách Memento Pattern được sử dụng để lưu và phục hồi trạng thái của `Originator`. `Caretaker` quản lý các trạng thái này thông qua một danh sách các `Memento`, nhưng không bao giờ tương tác trực tiếp với nội dung bên trong của chúng.

## Ví dụ

// Ví dụ triển khai Memento Pattern để lưu trạng thái đối tượng Player trong game.

## So sánh với các Pattern khác

So với Iterator, Memento tập trung vào việc lưu trữ trạng thái nội bộ của một đối tượng, còn Iterator tập trung vào việc truy cập tuần tự các phần tử trong bộ sưu tập.

## Kết luận

Memento Pattern rất hữu ích khi muốn lưu lại và khôi phục trạng thái của đối tượng mà không vi phạm encapsulation. Tuy nhiên cũng cần xem xét chi phí về bộ nhớ khi lưu trữ nhiều snapshot.