# Flyweight Pattern

## Khái niệm

Flyweight là một Pattern thuộc nhóm cấu trúc, nó giúp bạn có thể tạo nhiều đối tượng so với dung lượng RAM bằng cách chia sẽ các bộ phân chung giữa các đối tượng mà không phải giữa dữ liệu cho từng đối tượng.

## Hai trạng thái của Flyweight Object

Mục tiêu của Flyweight Pattern là giảm bộ nhớ bằng chia sẽ các đối tượng. Điều này được thể hiên bằng cách tách các thuộc tính của đối tượng thành hai trạng thái: Intrinsic và Extrinsic

- Intrinsic State: Trạng thái này chứa dữ liệu không thể thay đổi. Những dữ liệu đó được lưu trữ vĩnh viến bên trong đối tượng Flyweight. Vì vậy Flyweight object có thể chia sẻ. Dữ liệu Intrinsic thường không có trạng thái và không thay đổi. Điều này giúp khả năng sử dụng lại các thuộc tính đối tượng Flyweight giữa các đối tượng tượng tự khác.
- Extrinsic State: phụ thuộc vào ngữ cảnh của đối tượng flyweight. Trạng thái này chứa các thuốc tính và dữ liệu và được áp dụng hoặc được tính toán trong thời gian thực thi. Do đó, những dữ liệu đó không liêu vào bộ nhớ.

## Cấu Trúc

- Flyweight: có thể là interface hoặc abstract class, định nghĩa các thành phần của đối tượng.
- ConcreteFlyweight: Triển khai các phương thức Flyweight, nhưng phải đảm bảo dữ liệu không thay đổi và có thể chia sẽ.
- UnsharedFlyweight: Triển khai các phương thức Flyweight nhưng thể chia sẽ.
- FlyweightFactory: đây là Factory Pattern được sử dụng để giữa tham chiếu đến đối tượng Flyweight đã được tạo.

## Ví dụ áp dụng Flyweight Pattern



## Khi nào áp dụng

Chỉ sử dụng khi mẫu của bạn có số đố tượng lớn hơn Ram.