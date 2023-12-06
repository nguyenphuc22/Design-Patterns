# Creational Patterns

Creational Patterns cung cấp các giải pháp khởi tao đối tượng một cách linh hoạt và phù hợp với bối cảnh sử dụng. Các Pattern thuộc nhóm này gồm:

## [Singleton](Singleton.md)

Đảm bảo chỉ có duy nhất một instance của một class trong toàn bộ chương trình.

## [Factory Method](Factory-Method.md)

Định nghĩa một interface để tạo các đối tượng trong superclass nhưng cho phép lớp con quyết định instance nào sẽ được tạo.

## [Abstract Factory](Abstract-Factory.md)

Cung cấp một interface để tạo ra các họ đối tượng liên quan hoặc phụ thuộc lẫn nhau.

## [Builder](Builder.md)

Tách biệt quá trình khởi tạo đối tượng phức tạp khởi các đại diện của nó

## [Prototype](Prototype.md)

Tạo ra các đối tượng dựa trên một mẫu đối tượng ban đầu

Các Pattern này giải quyết vấn đề khởi tạo đối tượng một cách linh hoạt, thay vì khởi tạo trực tiếp bằng từ khóa new. Giúp tăng tính mềm dẻo và tái sử dụng code.