# Visitor

## Khái Niệm

**Visitor Pattern** là một mẫu thiết kế thuộc loại mẫu thiết kế hành vi (behavioral design pattern) trong phát triển phần mềm. Mẫu này giúp chúng ta tách biệt các phép toán khỏi đối tượng mà chúng hoạt động trên. Thông qua Visitor Pattern, chúng ta có thể thêm các chức năng mới mà không làm thay đổi các lớp của các đối tượng mà chúng tương tác.

### Tổng quan

- **Định Nghĩa của Pattern:** Visitor Pattern cho phép một hoặc nhiều đối tượng 'Visitor' định nghĩa một tập hợp các phép toán để áp dụng lên một tập các đối tượng 'Element' mà không làm thay đổi mã nguồn của những đối tượng này. Các 'Element' có một phương thức 'accept' mà nó nhận một 'Visitor' làm tham số. 'Visitor' này sau đó được áp dụng cho đối tượng 'Element'.

- **Mục Đích:** Mục đích chính của Visitor Pattern là cho phép thêm các hoạt động mới vào một tập hợp các lớp đối tượng mà không cần sửa đổi mã nguồn của chúng. Điều này giúp mã nguồn trở nên dễ dàng mở rộng hơn và giảm sự phụ thuộc giữa các chức năng và cấu trúc dữ liệu của đối tượng.

- **Ý Tưởng Cốt Lõi:** Ý tưởng cốt lõi của Visitor Pattern là tách biệt thuật toán từ các đối tượng mà nó hoạt động trên. Điều này cho phép chúng ta thêm các thuật toán mới mà không thay đổi định nghĩa của các đối tượng. Khi cần thực hiện một hoạt động trên một tập hợp các đối tượng, chúng ta có thể định nghĩa một đối tượng Visitor chứa hoạt động đó và sau đó cho phép các đối tượng đó chấp nhận Visitor, từ đó áp dụng hoạt động mà không làm thay đổi mã nguồn của chúng.

## Đặt vấn đề

Giả sử bạn có một cấu trúc cây đối tượng phức tạp đại diện cho một tài liệu. Bây giờ cần thêm chức năng xuất tài liệu ra nhiều định dạng khác nhau (json, xml, pdf...).

Làm thế nào để thêm chức năng mới mà không làm ảnh hưởng đến cấu trúc cây đối tượng hiện tại?

## Giải quyết

Visitor Pattern được áp dụng như sau:

- Định nghĩa một interface Visitor với các phương thức visit tương ứng với từng lớp Element.

- Các lớp Element sẽ có phương thức accept nhận vào một Visitor.

- Tạo các ConcreteVisitor triển khai các phương thức visit để thực hiện các thao tác cụ thể lên Element.

## Cấu trúc

Các thành phần chính trong Visitor Pattern:

- Visitor: định nghĩa các phương thức thao tác trên các Element.

- ConcreteVisitor: triển khai các phương thức trên.

- Element: định nghĩa phương thức accept nhận vào một Visitor.

- ConcreteElement: các lớp cụ thể cần áp dụng thao tác.

## Cách triển khai

Để triển khai Visitor trong Java, ta có thể:

- Định nghĩa interface Visitor với các phương thức visit tương ứng với từng Element.

- Các Element có phương thức accept nhận vào một Visitor.

- Các ConcreteVisitor triển khai các phương thức visit.

## Ví dụ

// Ví dụ minh họa Visitor Pattern áp dụng cho việc xuất tài liệu

## So sánh với các Pattern

So với Strategy, Visitor tách logic ra khỏi các đối tượng, trong khi Strategy nhóm các thuật toán lại với nhau.

## Kết luận

Visitor Pattern giúp tách rời các thao tác khỏi các đối tượng thực thi, giúp dễ dàng bảo trì và mở rộng. Tuy nhiên cũng cần cân nhắc để tránh lạm dụng dẫn đến phức tạp code.