# Mediator

## Khái Niệm

**Mediator Pattern**, trong lĩnh vực phát triển phần mềm, là một mẫu thiết kế hành vi. Nó giúp giảm sự phức tạp trong giao tiếp giữa nhiều đối tượng hoặc lớp bằng cách cung cấp một đối tượng trung gian, gọi là 'mediator'. Điều này giúp các đối tượng không giao tiếp trực tiếp với nhau, mà thông qua mediator, từ đó giảm thiểu sự phụ thuộc lẫn nhau và làm cho mã nguồn dễ bảo trì hơn.

### Tổng quan

- **Định Nghĩa của Pattern:** Mediator Pattern giới thiệu một đối tượng trung gian, gọi là 'Mediator', có nhiệm vụ điều phối giao tiếp giữa các đối tượng khác trong hệ thống. Mục tiêu là giảm sự phụ thuộc trực tiếp giữa các đối tượng, giúp giảm sự phức tạp trong quá trình phát triển và bảo trì.

- **Mục Đích:** Mục đích chính của Mediator Pattern là tạo ra một kênh giao tiếp trung tâm để các đối tượng có thể giao tiếp mà không cần biết về sự tồn tại của nhau. Điều này tạo điều kiện cho việc mở rộng và bảo trì hệ thống trở nên dễ dàng hơn.

- **Ý Tưởng Cốt Lõi:** Trong Mediator Pattern, 'Mediator' đóng vai trò là trung tâm điều phối. Nó giúp các đối tượng tương tác với nhau một cách gián tiếp và giảm thiểu sự phụ thuộc chặt chẽ, từ đó làm cho cấu trúc hệ thống trở nên linh hoạt và dễ quản lý hơn.

## Đặt vấn đề

Giả sử bạn đang phát triển một ứng dụng nhắn tin với các đối tượng User và ChatRoom. Ban đầu, mỗi User giao tiếp trực tiếp với ChatRoom để gửi tin nhắn.

Sau này, yêu cầu thay đổi là cần kiểm duyệt tin nhắn trước khi gửi đi. Lúc này, mối phụ thuộc trực tiếp giữa các đối tượng dẫn tới khó khăn trong việc thay đổi.

## Giải quyết

Mediator Pattern được áp dụng như sau:

- Định nghĩa một lớp Mediator đóng vai trò trung gian điều phối giữa các User và ChatRoom.

- Các User và ChatRoom không giao tiếp trực tiếp với nhau nữa mà thông qua Mediator.

- Khi có yêu cầu thay đổi, ta chỉ cần sửa đổi bên trong Mediator mà không ảnh hưởng các User và ChatRoom.

![](https://refactoring.guru/images/patterns/diagrams/mediator/structure.png)

## Cấu trúc

Các thành phần chính trong Mediator Pattern:

- Mediator: định nghĩa interface để giao tiếp với các Colleague.

- Colleague: giao tiếp với mediator thay vì giao tiếp trực tiếp với các Colleague khác.

- ConcreteMediator: triển khaiMediator để điều phối các Colleague.

- ConcreteColleague: các lớp cụ thể tương tác với mediator.

## Cách triển khai

Để triển khai Mediator Pattern trong Java, chúng ta có thể:

- Định nghĩa interface Mediator với các phương thức trung gian.

- Các lớp Colleague sẽ giữ một tham chiếu tới Mediator và gọi các phương thức đó thay vì giao tiếp trực tiếp.

- Lớp ConcreteMediator sẽ triển khai và điều phối các interation giữa các Colleague.

## Ví dụ

// Ví dụ triển khai Mediator Pattern với các lớp ChatRoom, User

## So sánh

So với Observer, Mediator tập trung vào việc điều phối giao tiếp giữa các đối tượng, còn Observer tập trung vào mối quan hệ một-nhiều giữa các đối tượng.

## Kết luận

Mediator Pattern hữu ích để giảm sự phụ thuộc trực tiếp giữa các lớp, dễ dàng mở rộng và thay đổi chương trình. Tuy nhiên cũng cần tránh lạm dụng mediator dẫn tới phức tạp hóa code.