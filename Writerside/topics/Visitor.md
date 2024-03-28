# Visitor

## Khái Niệm

**Visitor Pattern** là một mẫu thiết kế thuộc loại mẫu thiết kế hành vi (behavioral design pattern) trong phát triển phần mềm. Mẫu này giúp chúng ta tách biệt các phép toán khỏi đối tượng mà chúng hoạt động trên. Thông qua Visitor Pattern, chúng ta có thể thêm các chức năng mới mà không làm thay đổi các lớp của các đối tượng mà chúng tương tác.

### Tổng quan

- **Định Nghĩa của Pattern:** Visitor Pattern cho phép một hoặc nhiều đối tượng 'Visitor' định nghĩa một tập hợp các phép toán để áp dụng lên một tập các đối tượng 'Element' mà không làm thay đổi mã nguồn của những đối tượng này. Các 'Element' có một phương thức 'accept' mà nó nhận một 'Visitor' làm tham số. 'Visitor' này sau đó được áp dụng cho đối tượng 'Element'.

- **Mục Đích:** Mục đích chính của Visitor Pattern là cho phép thêm các hoạt động mới vào một tập hợp các lớp đối tượng mà không cần sửa đổi mã nguồn của chúng. Điều này giúp mã nguồn trở nên dễ dàng mở rộng hơn và giảm sự phụ thuộc giữa các chức năng và cấu trúc dữ liệu của đối tượng.

- **Ý Tưởng Cốt Lõi:** Ý tưởng cốt lõi của Visitor Pattern là tách biệt thuật toán từ các đối tượng mà nó hoạt động trên. Điều này cho phép chúng ta thêm các thuật toán mới mà không thay đổi định nghĩa của các đối tượng. Khi cần thực hiện một hoạt động trên một tập hợp các đối tượng, chúng ta có thể định nghĩa một đối tượng Visitor chứa hoạt động đó và sau đó cho phép các đối tượng đó chấp nhận Visitor, từ đó áp dụng hoạt động mà không làm thay đổi mã nguồn của chúng.

### Đặt vấn đề

Trong nhiều ứng dụng phần mềm, các lớp khác nhau thường phải thực hiện những nhiệm vụ tương tự nhưng với một số biến thể nhỏ dựa trên đặc điểm cụ thể của đối tượng. Khi một hệ thống được mở rộng để xử lý các loại đối tượng mới, việc thêm code mới vào các lớp hiện có có thể làm tăng sự phức tạp và giảm tính linh hoạt. Đặc biệt, trong các hệ thống xử lý nhiều đối tượng khác nhau, việc cập nhật và bảo trì mã nguồn trở nên khó khăn do sự chồng chéo và lặp lại code. Ví dụ, một ứng dụng phân tích tài liệu cần xử lý các loại tài liệu khác nhau như văn bản, bảng biểu và hình ảnh. Mặc dù các tài liệu này có thể chia sẻ một quy trình xử lý cơ bản, nhưng mỗi loại cần một số thao tác đặc biệt để phân tích hiệu quả.

```mermaid
graph TD;
    A[Tài liệu tổng quát] --> B[Văn bản]
    A --> C[Bảng biểu]
    A --> D[Hình ảnh]
    B --> E{Quy trình xử lý chung}
    C --> E
    D --> E
    E --> F[Tuỳ chỉnh theo loại]
```

### Giải pháp

Visitor Pattern giải quyết vấn đề này bằng cách cho phép thêm các thao tác mới vào một hệ thống đối tượng mà không cần sửa đổi cấu trúc của các lớp đối tượng. Pattern này sử dụng một lớp visitor mà có thể thực hiện một tập hợp các thao tác trên các đối tượng thuộc các lớp khác nhau mà không cần làm cho mã nguồn trở nên rối bời bởi logic dành riêng cho từng loại đối tượng. Trong ví dụ của ứng dụng phân tích tài liệu, có thể tạo các visitor khác nhau cho các thao tác như in, kiểm tra lỗi và phân tích sâu.

Khi áp dụng Visitor Pattern, cấu trúc của hệ thống trở nên rõ ràng và linh hoạt hơn, cho phép dễ dàng thêm vào hoặc sửa đổi các thao tác mà không làm ảnh hưởng đến các lớp đối tượng. Pattern này tách biệt được logic xử lý khỏi cấu trúc dữ liệu, từ đó làm giảm sự phụ thuộc giữa chúng và tăng khả năng tái sử dụng code.

```mermaid
classDiagram
    class DocumentElement {
        <<interface>>
        +accept(Visitor)
    }
    class Text  {
        +accept(Visitor)
    }
    class Table  {
        +accept(Visitor)
    }
    class Image {
        +accept(Visitor)
    }
    class Visitor {
        <<interface>>
        +visitText(Text)
        +visitTable(Table)
        +visitImage(Image)
    }

    DocumentElement <|-- Text : implements
    DocumentElement <|-- Table : implements
    DocumentElement <|-- Image : implements
```

Trong sơ đồ này, `DocumentElement` là một interface đại diện cho các loại phần tử của tài liệu mà có thể được "thăm" bởi các visitor. `Text`, `Table`, và `Image` là các lớp cụ thể biểu diễn các loại phần tử khác

## Cấu trúc của Visitor Pattern

```mermaid
classDiagram
      class Visitor {
        +visitConcreteElementA(ConcreteElementA)
        +visitConcreteElementB(ConcreteElementB)
      }
      class ConcreteVisitor1 {
        +visitConcreteElementA(ConcreteElementA) 
        +visitConcreteElementB(ConcreteElementB)
      }
      class ConcreteVisitor2 {
        +visitConcreteElementA(ConcreteElementA) 
        +visitConcreteElementB(ConcreteElementB)
      }
      class Element {
        +accept(Visitor)
      }
      class ConcreteElementA {
        +accept(Visitor)
      }
      class ConcreteElementB {
        +accept(Visitor)
      }
      
      Visitor <|.. ConcreteVisitor1 : Extends
      Visitor <|.. ConcreteVisitor2 : Extends
      Element <|.. ConcreteElementA : Extends
      Element <|.. ConcreteElementB : Extends
      ConcreteElementA ..> Visitor : Uses
      ConcreteElementB ..> Visitor : Uses
```

- `Visitor` là một interface hoặc abstract class chứa một loạt các phương thức visit(), mỗi phương thức cho một loại element khác nhau.
- `ConcreteVisitor1` và `ConcreteVisitor2` là các lớp cụ thể triển khai interface `Visitor`, cung cấp cách thực hiện cụ thể cho mỗi phương thức visit().
- `Element` là một interface hoặc abstract class chứa phương thức accept(), trong đó tham số là một đối tượng Visitor.
- `ConcreteElementA` và `ConcreteElementB` là các lớp cụ thể triển khai `Element`, mỗi lớp cung cấp triển khai cụ thể cho phương thức accept(), thường là gọi phương thức visit() của Visitor và truyền chính nó như một đối số.

## Cách triển khai Visitor Pattern

Hãy tưởng tượng một ứng dụng Zoo, nơi bạn muốn thực hiện các hoạt động khác nhau đối với các loài động vật mà không cần thay đổi các lớp động vật. Ví dụ, bạn muốn thực hiện "Feeding" và "Exercising" cho các loài động vật khác nhau. Đây là một tình huống lý tưởng để sử dụng Visitor Pattern.

### 1. Interface Visitor

Đây là Visitor, định nghĩa các hoạt động (trong trường hợp này là Feeding và Exercising) cho mỗi loại động vật.

```java
public interface AnimalVisitor {
    void visit(Lion lion);
    void visit(Tiger tiger);
    void visit(Elephant elephant);
}
```

### 2. Interface Element

Đây là Element, mô tả các loài động vật trong zoo.

```java
public interface Animal {
    void accept(AnimalVisitor visitor);
}
```

### 3. Concrete Visitor Classes

Các lớp này triển khai `AnimalVisitor` để xác định cách thức thực hiện các hoạt động cho từng loài động vật.

```java
public class FeedingVisitor implements AnimalVisitor {
    @Override
    public void visit(Lion lion) {
        System.out.println("Feeding the lion with some meat.");
    }

    @Override
    public void visit(Tiger tiger) {
        System.out.println("Feeding the tiger with chicken.");
    }

    @Override
    public void visit(Elephant elephant) {
        System.out.println("Feeding the elephant with fruits and vegetables.");
    }
}

public class ExercisingVisitor implements AnimalVisitor {
    @Override
    public void visit(Lion lion) {
        System.out.println("Taking the lion for a run.");
    }

    @Override
    public void visit(Tiger tiger) {
        System.out.println("Making the tiger jump through hoops.");
    }

    @Override
    public void visit(Elephant elephant) {
        System.out.println("Walking the elephant around the zoo.");
    }
}
```

### 4. Concrete Element Classes

Các lớp động vật cụ thể, mỗi loài sẽ có cách tiếp nhận (accept) khách thăm (visitor) riêng.

```java
public class Lion implements Animal {
    @Override
    public void accept(AnimalVisitor visitor) {
        visitor.visit(this);
    }
}

public class Tiger implements Animal {
    @Override
    public void accept(AnimalVisitor visitor) {
        visitor.visit(this);
    }
}

public class Elephant implements Animal {
    @Override
    public void accept(AnimalVisitor visitor) {
        visitor.visit(this);
    }
}
```

### 5. Sử dụng Pattern

Đoạn mã sau đây mô tả cách các động vật được thăm bởi các visitor khác nhau để thực hiện các hoạt động như feeding và exercising.

```java
public class ZooVisitorDemo {
    public static void main(String[] args) {
        Animal[] animals = new Animal[]{new Lion(), new Tiger(), new Elephant()};

        AnimalVisitor feedingVisitor = new FeedingVisitor();
        AnimalVisitor exercisingVisitor = new ExercisingVisitor();

        System.out.println("Zoo Feeding Time:");
        for (Animal animal : animals) {
            animal.accept(feedingVisitor);
        }

        System.out.println("\nZoo Exercise Time:");
        for (Animal animal : animals) {
            animal.accept(exercisingVisitor);
        }
    }
}
```

Trong ví dụ này, `FeedingVisitor` và `ExercisingVisitor` đại diện cho các hoạt động cụ thể được thực hiện trên các loài động vật. Mỗi loài động vật (`Lion`, `Tiger`, `Elephant`) đều triển khai interface `Animal` và định nghĩa phương thức `accept()` để chấp nhận `AnimalVisitor`. Phần demo `ZooVisitorDemo` minh họa cách thức các `Animal` được "thăm" bởi các `AnimalVisitor` để thực hiện feeding và exercising mà không cần sửa đổi code trong các lớp `Animal`.

## Ví dụ

// Ví dụ minh họa Visitor Pattern áp dụng cho việc xuất tài liệu

## So sánh với các Pattern

So với Strategy, Visitor tách logic ra khỏi các đối tượng, trong khi Strategy nhóm các thuật toán lại với nhau.

## Kết luận

Visitor Pattern giúp tách rời các thao tác khỏi các đối tượng thực thi, giúp dễ dàng bảo trì và mở rộng. Tuy nhiên cũng cần cân nhắc để tránh lạm dụng dẫn đến phức tạp code.