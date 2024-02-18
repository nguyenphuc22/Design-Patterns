# State Pattern

## Khái Niệm

**State Pattern**, trong lĩnh vực phát triển phần mềm, là một mẫu thiết kế hành vi cho phép một đối tượng thay đổi hành vi của mình khi trạng thái nội bộ thay đổi. Mẫu này coi trạng thái là một đối tượng độc lập và đối tượng chính có thể thay đổi hành vi của mình bằng cách thay đổi trạng thái hiện tại của nó. Điều này được thực hiện mà không cần sửa đổi mã nguồn của đối tượng, giúp cho việc quản lý các thay đổi về trạng thái trở nên dễ dàng và linh hoạt.

### Tổng quan

- **Định Nghĩa của Pattern:** State Pattern bao gồm đối tượng 'Context' (môi trường hoặc ngữ cảnh sử dụng) và một tập hợp các đối tượng 'State' (trạng thái). 'Context' giữ một tham chiếu tới một 'State' hiện tại và có thể thay đổi tham chiếu này để chuyển đổi giữa các trạng thái khác nhau. Các 'State' biết cách xử lý các yêu cầu từ 'Context', và mỗi 'State' cung cấp hành vi cụ thể phù hợp với trạng thái của 'Context'.

- **Mục Đích:** Mục đích của State Pattern là giúp quản lý và cơ cấu lại mã nguồn liên quan đến các quyết định điều khiển dựa trên trạng thái, bằng cách tách biệt hành vi liên quan đến trạng thái cụ thể ra khỏi 'Context'. Điều này giúp giảm sự phức tạp và tăng tính mô-đun của mã nguồn, cũng như dễ dàng thêm mới hoặc sửa đổi các trạng thái mà không ảnh hưởng đến 'Context'.

- **Ý Tưởng Cốt Lõi:** Ý tưởng cốt lõi của State Pattern là "đóng gói sự thay đổi". Bằng cách sử dụng các đối tượng 'State' để đại diện cho các trạng thái khác nhau và cho phép 'Context' thay đổi trạng thái của mình, hệ thống có thể thay đổi hành vi một cách linh hoạt theo trạng thái mà không cần phải viết các câu lệnh điều kiện phức tạp. Điều này giúp mã nguồn trở nên dễ hiểu, dễ bảo trì và mở rộng hơn.

## Đặt vấn đề

Giả sử bạn đang phát triển một trò chơi, có lớp NhânVật có các trạng thái: đi bộ, chạy, nhảy. Mỗi trạng thái sẽ có các hành vi riêng.

Ban đầu, mọi logic xử lý được đặt trong lớp NhânVật dẫn đến lớp này phình to, khó bảo trì.

Làm thế nào để tổ chức code cho dễ quản lý hơn?

## Giải quyết

State Pattern được áp dụng như sau:

- Mỗi trạng thái được đóng gói thành một lớp riêng biệt, triển khai từ một interface chung.

- Lớp NhânVật sẽ lưu trữ trạng thái hiện tại và delegate mọi hành vi cho trạng thái đó.

- Khi trạng thái thay đổi, NhânVật sẽ chuyển sang trạng thái mới.

![](https://refactoring.guru/images/patterns/diagrams/state/structure.png)

## Cấu trúc

Các thành phần chính trong State Pattern:

- Context: lớp chứa tham chiếu đến trạng thái hiện tại.

- State: interface chung cho các trạng thái.

- ConcreteState: các lớp triển khai cụ thể cho mỗi trạng thái.

## Cách triển khai

Để triển khai State Pattern trong Java, chúng ta có thể:

- Định nghĩa một interface chung cho State.

- Tạo các lớp Concrete State triển khai interface đó.

- Lớp Context sẽ lưu trữ instance của State hiện tại.

## Ví dụ

// Ví dụ State Pattern áp dụng cho trạng thái của nhân vật trong game

## So sánh với các Pattern

So với Strategy, State tập trung vào việc thay đổi hành vi dựa trên trạng thái đối tượng. Strategy tập trung vào việc thay đổi thuật toán riêng lẻ.

## Kết luận

State Pattern giúp tổ chức code dựa trên trạng thái của đối tượng, dễ mở rộng và bảo trì hơn. Tuy nhiên cũng cần tránh lạm dụng và làm phức tạp hóa code.