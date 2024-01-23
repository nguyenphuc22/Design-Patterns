# Memento

## Khái Niệm

**Memento Pattern**, trong lĩnh vực phát triển phần mềm, là một mẫu thiết kế hành vi. Nó được sử dụng để lưu trữ trạng thái của một đối tượng (được gọi là 'memento') mà không vi phạm tính đóng gói, cho phép đối tượng quay lại trạng thái trước đó mà không cần phụ thuộc vào các lớp khác. Memento Pattern cung cấp khả năng 'undo' hoặc 'rollback' trong các ứng dụng, mà không làm lộ chi tiết triển khai nội bộ của đối tượng.

### Tổng quan

- **Định Nghĩa của Pattern:** Memento Pattern bao gồm việc lưu trữ bản sao của trạng thái nội bộ của một đối tượng vào một đối tượng khác mà không làm lộ thông tin nội bộ. Điều này cho phép khôi phục trạng thái trước đó của đối tượng mà không vi phạm nguyên tắc đóng gói.

- **Mục Đích:** Mục đích chính của Memento Pattern là cho phép đối tượng quay lại trạng thái trước đó mà không cần phải lưu trữ thông tin nội bộ của đối tượng ra bên ngoài. Điều này giúp tăng tính bảo mật và độc lập của đối tượng, đồng thời cung cấp chức năng 'undo' mà không làm ảnh hưởng tới kiến trúc tổng thể của hệ thống.

- **Ý Tưởng Cốt Lõi:** Trong Memento Pattern, có ba thành phần chính: 'Originator' (tạo ra trạng thái để lưu), 'Memento' (lưu trữ trạng thái của 'Originator'), và 'Caretaker' (quản lý 'Memento' mà không cần biết chi tiết bên trong). 'Caretaker' yêu cầu lưu trạng thái từ 'Originator' và có thể yêu cầu 'Originator' quay lại trạng thái đã lưu trước đó, nhờ vào 'Memento'.

## Định nghĩa

Memento Pattern lưu trữ trạng thái nội bộ của một đối tượng vào một đối tượng riêng biệt được gọi là Memento. Đối tượng ban đầu có thể khôi phục lại trạng thái từ Memento.

## Mục đích

- Lưu lại và khôi phục trạng thái của một đối tượng mà không vi phạm encapsulation.

- Cung cấp khả năng hoàn tác (undo/rollback) trong quá trình thao tác với đối tượng.

## Đặt vấn đề

Giả sử bạn đang phát triển một trò chơi có đối tượng Player đại diện cho người chơi. Trong quá trình chơi, trạng thái của Player (vị trí, máu, điểm,..) liên tục thay đổi.

Để người chơi có thể quay lại trạng thái trước đó khi cần thiết, chúng ta cần lưu lại các trạng thái đó một cách hiệu quả. Đồng thời, không làm ảnh hưởng tới encapsulation của lớp Player.

## Giải quyết

Memento Pattern giải quyết bài toán trên bằng cách:

- Tạo ra một lớp Memento để lưu trữ trạng thái của đối tượng. Memento chỉ lưu trữ dữ liệu, không có hành vi.

- Lớp Player tạo ra đối tượng Memento chứa trạng thái của nó, và có thể khôi phục lại trạng thái từ Memento.

- Originator không truy cập trực tiếp vào Memento, mà thông qua Caretaker.

![](https://refactoring.guru/images/patterns/diagrams/memento/structure.png)

## Cấu trúc

Các thành phần trong Memento Pattern:

- Originator: đối tượng cần lưu trữ trạng thái.

- Memento: đối tượng lưu trữ trạng thái của Originator.

- Caretaker: quản lý các đối tượng Memento.

## Cách triển khai

Để triển khai Memento Pattern trong Java, chúng ta có thể:

- Tạo lớp Memento với các trường dữ liệu cần lưu trữ.

- Lớp Originator sẽ tạo ra đối tượng Memento và lưu/khôi phục trạng thái từ nó.

- Caretaker sẽ quản lý các Memento.

## Ví dụ

// Ví dụ triển khai Memento Pattern để lưu trạng thái đối tượng Player trong game.

## So sánh với các Pattern khác

So với Iterator, Memento tập trung vào việc lưu trữ trạng thái nội bộ của một đối tượng, còn Iterator tập trung vào việc truy cập tuần tự các phần tử trong bộ sưu tập.

## Kết luận

Memento Pattern rất hữu ích khi muốn lưu lại và khôi phục trạng thái của đối tượng mà không vi phạm encapsulation. Tuy nhiên cũng cần xem xét chi phí về bộ nhớ khi lưu trữ nhiều snapshot.