# Observer

## Khái Niệm

**Observer Pattern**, trong lĩnh vực phát triển phần mềm, là một mẫu thiết kế hành vi. Nó được sử dụng để tạo một cơ chế quản lý mối quan hệ một-đến-nhiều giữa các đối tượng, sao cho khi trạng thái của một đối tượng thay đổi, tất cả đối tượng phụ thuộc (observers) sẽ được thông báo và cập nhật tự động. Observer Pattern thường được sử dụng để triển khai các hệ thống phản hồi sự kiện, trong đó đối tượng có thể gửi thông báo tới các đối tượng khác mà không cần biết rõ về những đối tượng đang lắng nghe.

### Tổng quan

- **Định Nghĩa của Pattern:** Observer Pattern bao gồm hai loại đối tượng chính: 'Subject' (đối tượng quan sát) và 'Observer' (đối tượng được thông báo). 'Subject' duy trì một danh sách các 'Observer' quan tâm tới trạng thái của nó và thông báo cho tất cả 'Observers' khi có bất kỳ thay đổi nào về trạng thái.

- **Mục Đích:** Mục đích của Observer Pattern là tạo điều kiện cho việc tạo ra các ứng dụng có cấu trúc linh hoạt, mở rộng được và dễ bảo trì bằng cách giảm thiểu sự phụ thuộc lẫn nhau giữa các đối tượng. Khi một 'Subject' thay đổi trạng thái, 'Observers' của nó sẽ tự động được thông báo và cập nhật mà không cần sự can thiệp trực tiếp.

- **Ý Tưởng Cốt Lõi:** Trong Observer Pattern, 'Subject' đóng vai trò là nhà xuất bản (publisher), trong khi 'Observers' đóng vai trò như các người đăng ký (subscribers). Mỗi khi 'Subject' có một thay đổi trạng thái, nó sẽ thông báo cho tất cả 'Observers' của mình. Điều này cho phép tách biệt giữa 'Subject' và 'Observers', tăng cường tính mô-đun và dễ dàng mở rộng hệ thống. 'Observers' có thể đăng ký hoặc hủy đăng ký với 'Subject' một cách linh hoạt mà không ảnh hưởng tới 'Subject' hoặc các 'Observers' khác.


## Đặt vấn đề

Giả sử bạn đang phát triển một website thương mại điện tử với các chức năng sau:

- Người dùng có thể đăng ký nhận thông báo khi một sản phẩm nào đó có giá giảm.

- Khi giá sản phẩm thay đổi, tất cả người dùng đã đăng ký sẽ nhận được thông báo.

Làm thế nào để triển khai khi có hàng triệu người dùng cùng theo dõi hàng triệu sản phẩm khác nhau?

## Giải quyết

Observer Pattern được áp dụng như sau:

- Định nghĩa một Subject (đối tượng chủ đề) đại diện cho sản phẩm.

- Người dùng (Observer) có thể đăng ký theo dõi Subject.

- Khi trạng thái của Subject thay đổi (giá sản phẩm) thì sẽ thông báo tới tất cả Observer đã đăng ký.

![](https://refactoring.guru/images/patterns/diagrams/observer/structure.png)

## Cấu trúc

Các thành phần trong Observer Pattern:

- Subject: đối tượng chủ thể cần theo dõi. Nó duy trì danh sách các Observer và thông báo cho chúng khi trạng thái thay đổi.

- Observer: đối tượng quan sát Subject. Nó đăng ký theo dõi Subject và cập nhật khi nhận được thông báo từ Subject.

- ConcreteSubject và ConcreteObserver: các cài đặt cụ thể.

## Cách triển khai

Để triển khai Observer Pattern trong Java, có thể:

- Sử dụng interface java.util.Observable và java.util.Observer.
- Tự định nghĩa Subject, Observer interface và các cài đặt tương ứng.

## Ví dụ

// Ví dụ đăng ký nhận thông báo khi giá sản phẩm thay đổi

## So sánh

So với PubSub, Observer tập trung vào mối quan hệ giữa các object, còn PubSub tập trung vào việc truyền thông điệp.

## Kết luận

Observer Pattern thích hợp để xây dựng các chức năng thông báo sự kiện trong hệ thống. Tuy nhiên cũng cần tránh lạm dụng và làm phức tạp hóa code.