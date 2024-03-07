# Template Method

## Khái Niệm

**Template Pattern** là một mẫu thiết kế thuộc loại mẫu thiết kế hành vi (behavioral design pattern) trong phát triển phần mềm. Mẫu này hoạt động bằng cách xác định khung sườn của một thuật toán trong một phương thức, hoãn một số bước cho các lớp con. Template Pattern cho phép lớp con có thể thay đổi hoặc mở rộng các bước cụ thể của thuật toán mà không thay đổi cấu trúc tổng thể của thuật toán.

### Tổng quan

- **Định Nghĩa của Pattern:** Template Pattern bao gồm hai thành phần chính là một lớp trừu tượng chứa phương thức template và một hoặc nhiều lớp con thực thi các bước cụ thể của thuật toán. Phương thức template xác định các bước của một thuật toán và thứ tự chúng nên được thực hiện, trong khi các lớp con thì triển khai chi tiết của các bước đó.

- **Mục Đích:** Mục đích của Template Pattern là tạo ra một cấu trúc thuật toán trong một phương thức, hoãn một số bước lại cho các lớp con. Mẫu này giúp tái sử dụng mã nguồn và tránh sự trùng lặp, đồng thời cung cấp một cách để các lớp con có thể mở rộng một số phần cụ thể của thuật toán mà không làm thay đổi cấu trúc thuật toán chính.

- **Ý Tưởng Cốt Lõi:** Ý tưởng cốt lõi của Template Pattern là "Inversion of Control", tức là đảo ngược quyền kiểm soát. Thay vì lớp con gọi phương thức từ lớp cơ sở, trong Template Pattern, lớp cơ sở gọi phương thức từ lớp con, điều này được thực hiện qua cách triển khai các phương thức trừu tượng trong lớp cơ sở. Điều này giúp định nghĩa khung của thuật toán trong lớp cơ sở nhưng để các lớp con xác định một số phần cụ thể.

## Đặt vấn đề

Giả sử bạn cần xây dựng một ứng dụng có khả năng xuất dữ liệu ra nhiều định dạng khác nhau (csv, xml, json...).

Các bước xuất dữ liệu đều tương tự nhau, nhưng định dạng output thì khác nhau. Việc copy-paste code sẽ dẫn tới khó khăn trong bảo trì sau này.

## Giải quyết

Template Method được áp dụng như sau:

- Định nghĩa một lớp Abstract chứa phương thức template method định nghĩa bố cục chung của thuật toán.

- Cài đặt các bước trừu tượng trong template method.

- Các lớp con sẽ cài đặt lại các bước trừu tượng này.


## Cấu trúc

Các thành phần chính trong Template Method Pattern:

- AbstractClass: định nghĩa template method và các phương thức trừu tượng.

- ConcreteClass: cài đặt lại các phương thức trừu tượng.

## Cách triển khai

Để triển khai Template Method trong Java, chúng ta có thể:

- Tạo một abstract class khai báo các phương thức trừu tượng.

- Cài đặt một template method sử dụng các phương thức trừu tượng đó.

- Các lớp con sẽ cài đặt lại các phương thức trừu tượng.

## Ví dụ

// Ví dụ Template Method áp dụng cho export dữ liệu có định dạng khác nhau

## So sánh với các Pattern

So với Strategy, Template Method định nghĩa bố cục của thuật toán và gọi các phương thức trừu tượng. Strategy định nghĩa riêng các thuật toán có thể hoán đổi cho nhau.

## Kết luận

Template Method giúp tái sử dụng code và tránh lặp lại phần khung của thuật toán giữa các lớp. Tuy nhiên cần cân nhắc khi sử dụng để tránh phức tạp hóa code.
