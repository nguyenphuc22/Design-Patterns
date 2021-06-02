# Facade

## Khái niệm

Facede Pattern là một Pattern thuộc nhóm cấu trúc (Structural Pattern). Pattern này cung cấp một giao diện chung đơn giản để kết nối một library, framework hoặc một lớp nào đó rất phức tạp.

## Đặt vấn đề

Hãy tưởng tượng bạn sử dụng một thư viện của bên thứ ba. Mọi chuyện sẽ không có gì cho đến khi bạn làm việc với một loạt các đối tượng trong thư viện và chúng liên kết với nhau rất phức tạp và có tuần tự khởi tạo.

Kết quả, khi đã kết hợp code của mình và thư viện thành công, thì code của ứng dụng của bạn trở nên phức tạp, khó mở rộng và bảo trì.

## Giái pháp

Facade Pattern sẽ giúp bạn trọng việc này, pattern này sẽ giúp bạn liên kết với nhiều đối tượng trong thư viện thứ ba và chỉ cung cấp cho bạn các interface đơn giản để sử dụng. Lưu ý, pattern này chỉ cung cấp một số chức năng mà người dùng thật sự  cần.

## Cấu Trúc

// Chèn Hình

- Facede: Phân phối yêu của Client đến các Subsystems đảm nhận công việc.
- Subsystems: cài đặt các phương thức của mình và implement Facede.
- Client: người sử dụng Facade để tương tác với subsystem.

## Ví dụ áp dụng Facede

## Khi nào áp dụng

