# Bridge Pattern

## Khái niệm

Bride là một Pattern thuộc nhóm cấu trúc. Nó tách một lớp lớn hoặc các lớp có quan hệ chặt chẽ với nhau thành các phần có thể phát triển một cách độc lập.

## Đặt vấn đề

Giả sử, bạn có một lớp `vehicle` với hai lớp phụ (subclass): `BicycleBike` và `MotorBike`. Bạn muốn mở rộng thêm phương tiện có thêm màu sắc và bạn thêm thuộc tính `Red` và `Blue`. Cách này vẫn chạy được, nhưng bạn phải tạo đến bốn lớp (Class) cho sự kết hợp như `BlueBicycleBike` and `RedMotorBike`

// Chèn Hình

Với mô hình này, khi thêm mới một phương tiện hoặc màu sắc mới bạn buộc phải tạo thêm đầy đủ các thuộc tính. Điều này làm cho tôn thời gian và khó kiểm soát.

## Giải pháp

Mấu chốt của vấn đề là ta đang cố gắng nhét quá nhiều thứ vào lớp abstract, mà các thứ trên lại phát triển theo hướng khác nhau.

// Chèn Hình

Mẫu Bridge Pattern sẽ giải quyết vấn đề này bằng cách tách chia nhỏ đối tượng abstract và các đối tượng, sau đó liên kết hai abstract lại. Trong trường hợp này phương tiện sẽ có màu sắc, vì thế là quan hệ has-a

## Cấu Trúc

// Chèn Hình

- The Abstraction:  cung cấp mức quản lý cấp cao, nhầm để quản lý các công việc do các đối tượng cụ thể thực hiện (Implementation)
- The Implementation:  Định ra các interface cho các đối tượng khác thực hiện. Thông thường nó là interface định ra các tác vụ nào đó của abstraction.
- Concrete Implementations: chứa các logic riêng và implement các tác vụ do implementation định ra.
- Refined Abstractions: Thực hiện các implement phương thức định ra trong Abstraction.

## Ví dụ áp dụng Bridge Pattern

