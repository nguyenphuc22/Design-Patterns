# Giới thiệu Design Pattern

## Định nghĩa Design Pattern

Design Pattern là một kỹ thuật trong thiết kế phần mềm, cung cấp các giải pháp tối ưu và đã được kiểm nghiệm để giải quyết những vấn đề thường gặp. Áp dụng Design Pattern giúp lập trình viên tiết kiệm thời gian, công sức và tạo ra mã nguồn chất lượng, dễ bảo trì.

## Lịch sử ra đời và phát triển

Design Pattern được ra đời từ những năm 1970, song song với sự phát triển của lập trình hướng đối tượng (OOP). Khái niệm này trở nên phổ biến vào năm 1994, khi cuốn sách kinh điển "Design Patterns: Elements Of Reusable Object-Oriented Software" của bộ tứ Erich Gamma, Richard Helm, Ralph Johnson và John Vlissides (còn gọi là Gang of Four - GoF) được xuất bản.

Kể từ đó, Design Pattern không ngừng được mở rộng và hoàn thiện để đáp ứng những yêu cầu ngày càng cao trong phát triển phần mềm hiện đại. Nhiều pattern mới ra đời, được ứng dụng rộng rãi trong các dự án thực tế.

## Ý nghĩa và lợi ích của Design Pattern

Design Pattern mang lại nhiều giá trị trong lập trình:

- **Tối ưu giải pháp:** Pattern cung cấp những phương pháp đã được chứng minh hiệu quả để xử lý vấn đề, giúp tiết kiệm thời gian tìm tòi, thử nghiệm.
- **Tăng tính tái sử dụng của code:** Áp dụng pattern giúp mã nguồn được cấu trúc tốt hơn, dễ tái sử dụng, giảm thiểu việc viết lại code.
- **Cải thiện khả năng bảo trì và mở rộng:** Code tuân thủ pattern có tính module hóa cao, dễ hiểu, dễ bảo trì và mở rộng tính năng về sau.
- **Nâng cao tính ổn định:** Sử dụng các thành phần đã được kiểm nghiệm giúp hạn chế tối đa lỗi tiềm ẩn và nâng cao độ tin cậy của phần mềm.
- **Tạo tiền đề phát triển Agile:** Các pattern tạo ra module độc lập, giúp team lập trình song song và tích hợp dễ dàng, phù hợp cho phát triển Agile.

Tóm lại, Design Pattern là một phần không thể thiếu với mọi lập trình viên, là nền tảng để xây dựng phần mềm hiệu quả, chất lượng và bền vững.

# 2. Phân loại Design Pattern

Design Pattern thường được chia thành 3 nhóm chính:

## 2.1 Creational Design Patterns (Nhóm khởi tạo)

Creational Pattern cung cấp giải pháp để khởi tạo đối tượng một cách linh hoạt, phù hợp với hoàn cảnh sử dụng. Mục đích là tối ưu quá trình tạo đối tượng, hạn chế sự phụ thuộc và dễ dàng mở rộng code. Một số pattern tiêu biểu:

[Singleton](Singleton.md): Đảm bảo một class chỉ có duy nhất một instance và cung cấp một điểm truy cập toàn cục đến nó.

[Factory Method](Factory-Method.md): Định nghĩa interface để khởi tạo đối tượng nhưng để cho lớp con quyết định class nào được dùng để khởi tạo.

[Abstract Factory](Abstract-Factory.md): Cung cấp một interface cho việc tạo lập các đối tượng (có liên hệ với nhau) mà không cần qui định các class cụ thể của chúng.

[Builder](Builder.md): Tách rời việc xây dựng (construction) một đối tượng phức tạp khỏi biểu diễn của nó sao cho cùng một tiến trình xây dựng có thể tạo ra các biểu diễn khác nhau.

[Prototype](Prototype.md): Qui định loại của các đối tượng cần tạo bằng cách dùng một đối tượng mẫu, tạo mới nhờ vào sao chép đối tượng mẫu này.

## 2.2 Structural Design Patterns (Nhóm cấu trúc)

Structural Pattern liên quan đến cách tổ chức cấu trúc của các lớp và đối tượng để tạo thành những cấu trúc lớn hơn. Chúng giúp xây dựng, định hình các mối quan hệ giữa các thực thể, làm cho hệ thống dễ dàng thay đổi, mở rộng mà vẫn đảm bảo tính linh hoạt và hiệu quả. Ví dụ một số pattern nổi bật:

[Adapter](Adapter.md): Cho phép các interface không liên quan tới nhau có thể làm việc cùng nhau.

[Bridge](Bridge.md): Tách rời ngữ nghĩa của một vấn đề khỏi việc cài đặt, mở rộng và tái sử dụng dễ dàng hơn.

[Composite](Composite.md): Tổ chức các đối tượng theo cấu trúc phân cấp dạng cây, từ đó xử lý các đối tượng riêng lẻ và nhóm đối tượng như nhau.

[Decorator](Decorator.md): Gán thêm trách nhiệm cho đối tượng (mở rộng chức năng) lúc runtime mà không thay đổi cấu trúc ban đầu.

[Facade](Facade.md): Cung cấp một interface thuần nhất cho một tập hợp các interface trong một "subsystem", giúp đơn giản hóa việc sử dụng.

[Flyweight](Flyweight.md): Cho phép tái sử dụng đối tượng tương tự đã tồn tại bằng cách lưu trữ chúng, tiết kiệm bộ nhớ và tăng hiệu năng.

[Proxy](Proxy.md): Cung cấp đối tượng đại diện cho một đối tượng khác, để kiểm soát quá trình truy cập vào đối tượng gốc.

## 2.3 Behavioral Design Patterns (Nhóm hành vi)

Behavioral Pattern tập trung vào cách giao tiếp, phân công trách nhiệm và điều phối giữa các đối tượng, lớp trong một chương trình. Chúng xác định cách thức và quy tắc để các thực thể hoạt động cùng nhau một cách linh hoạt, có tổ chức. Dưới đây là một số pattern đại diện:

[Chain of Responsibility](Chain-Of-Responsibility.md): Khắc phục việc ghép cặp giữa bộ gởi và bộ nhận thông điệp. Các đối tượng nhận thông điệp được kết nối thành một chuỗi và thông điệp được chuyển dọc theo chuỗi nầy đến khi gặp được đối tượng xử lý nó.

[Command](Command.md): Mỗi yêu cầu (thực hiện một thao tác nào đó) được bao bọc thành một đối tượng. Các yêu cầu sẽ được lưu trữ và gởi đi như các đối tượng.

[Iterator](Iterator.md): Truy xuất các phần tử của đối tượng dạng tập hợp tuần tự (list, array, …) mà không phụ thuộc vào biểu diễn bên trong của các phần tử.

[Mediator](Mediator.md): Định nghĩa một đối tượng để bao bọc sự tương tác (interaction) giữa một số đối tượng với nhau.

[Memento](Memento.md): Hiệu chỉnh và trả lại như cũ trạng thái bên trong của đối tượng mà vẫn không vi phạm việc bao bọc dữ liệu.

[Observer](Observer.md): Định nghĩa sự phụ thuộc một-nhiều giữa các đối tượng sao cho khi một đối tượng thay đổi trạng thái thì tất cả các đối tượng phụ thuộc nó cũng thay đổi theo.

[State](State.md): Cho phép một đối tượng thay đổi hành vi khi trạng thái bên trong của nó thay đổi, ta có cảm giác như class của đối tượng bị thay đổi.

[Strategy](Strategy.md): Bao bọc một họ các thuật toán bằng các lớp đối tượng để thuật toán có thể thay đổi độc lập đối với chương trình sử dụng thuật toán.

[Template Method](Template-Method.md): Định nghĩa phần khung của một thuật toán, tức là một thuật toán tổng quát gọi đến một số phương thức chưa được cài đặt trong lớp cơ sở, việc cài đặt các phương thức được ủy nhiệm cho các lớp kế thừa.

[Visitor](Visitor.md): Cho phép định nghĩa thêm phép toán mới tác động lên các phần tử của một cấu trúc đối tượng mà không cần thay đổi các lớp định nghĩa cấu trúc đó.

# 3. Sử dụng Design Pattern

## Nguyên tắc và phương pháp áp dụng Design Pattern

Để áp dụng Design Pattern một cách hiệu quả, chúng ta cần nắm vững những nguyên tắc cơ bản sau:

- **Xác định rõ vấn đề:** Trước tiên cần hiểu rõ bản chất vấn đề cần giải quyết. Chỉ khi thấu hiểu vấn đề thì chúng ta mới đưa ra được giải pháp phù hợp.

- **Nắm vững Design Pattern:** Ngoài việc nắm tên gọi, cần hiểu rõ cách thức hoạt động, điều kiện áp dụng và hệ quả của các pattern. Điều này giúp ta lựa chọn pattern đúng đắn cho từng hoàn cảnh.

- **Linh hoạt ứng dụng:** Design Pattern chỉ là những hướng dẫn tổng quát, đòi hỏi người lập trình phải sáng tạo, linh động khi đưa vào thực tế. Đôi khi cần phải tuỳ biến, kết hợp pattern để phù hợp với yêu cầu.

- **Hướng tới mục đích chung:** Khi áp dụng pattern, phải luôn nhớ rằng chúng phục vụ cho việc xây dựng phần mềm tốt hơn. Vì thế đừng coi pattern là cứu cánh, lạm dụng chúng chỉ khiến mã nguồn trở nên cồng kềnh, khó hiểu.

- **Trao dồi kinh nghiệm:** Khả năng vận dụng pattern hiệu quả đến từ kinh nghiệm làm việc thực tế. Hãy tích lũy qua mỗi dự án, rút kinh nghiệm từ những thành công và thất bại để ngày càng sử dụng pattern một cách thuần thục.

Có 2 phương pháp chính để đưa Design Pattern vào ứng dụng:

- **1. Áp dụng trực tiếp:** Dựa trên hiểu biết về pattern, lập trình viên tự cài đặt chúng vào mã nguồn ứng dụng. Đây là phương pháp đòi hỏi kinh nghiệm và tốn nhiều công sức, tuy nhiên nó mang lại sự chủ động và kiểm soát trọn vẹn.

- **2. Thông qua thư viện/framework:**     Nhiều thư viện và framework đã tích hợp sẵn các pattern phổ biến. Chỉ cần biết cách sử dụng, lập trình viên có thể nhanh chóng đưa pattern vào dự án một cách bài bản. Tuy nhiên cần lưu ý, mỗi thư viện/framework sẽ có quy ước và hạn chế riêng, ít nhiều ảnh hưởng đến tính linh động của ứng dụng.

## Lợi ích của Design Pattern trong phát triển phần mềm

Áp dụng Design Pattern mang lại nhiều lợi ích thiết thực cho quá trình phát triển phần mềm:

- **Nâng cao chất lượng mã nguồn:** Code sử dụng pattern thường có cấu trúc tốt, dễ đọc, dễ bảo trì, giảm thiểu rủi ro tiềm ẩn. Điều này giúp nâng cao năng suất lao động và chất lượng sản phẩm.
- **Giảm thời gian phát triển:** Pattern cung cấp những giải pháp "tối ưu", "chuẩn mực" để xử lý vấn đề thường gặp. Nhờ đó, lập trình viên không mất công "đặt lại bánh xe", rút ngắn đáng kể thời gian phát triển dự án.
- **Thúc đẩy tái sử dụng và mở rộng:** Bản thân mỗi pattern đã thể hiện tính tái sử dụng. Bên cạnh đó, chúng còn giúp hình thành các module, component có khả năng tái sử dụng cao và dễ dàng mở rộng.
- **Tăng khả năng giao tiếp, hợp tác:** Pattern như một ngôn ngữ chung giúp lập trình viên dễ dàng trao đổi ý tưởng, cộng tác trong dự án. Mỗi thành viên đều hiểu rõ nhiệm vụ và vị trí của từng thành phần trong tổng thể hệ thống.
- **Nâng tầm kiến trúc hệ thống:** Áp dụng đúng mực và hiệu quả các pattern giúp kiến trúc hệ thống trở nên rõ ràng, vững chắc. Chúng tạo một "bộ khung" cho toàn bộ hệ thống, đảm bảo tính nhất quán và hiệu quả trong mọi hoạt động phát triển về sau.

## Lưu ý khi áp dụng Design Pattern

Tuy nhiên, Design Pattern không phải "thần dược", chúng ta cần lưu ý một số điểm sau:

- **Không lạm dụng:** Nhiều người có xu hướng sử dụng pattern một cách máy móc, không cần thiết. Điều này chỉ khiến mã nguồn trở nên rối rắm, khó bảo trì. Chỉ sử dụng pattern khi thực sự cần thiết và có lợi cho dự án.
- **Linh hoạt ứng biến:** Pattern chỉ đưa ra ý tưởng tổng quát, khi triển khai cần tùy biến cho phù hợp với hoàn cảnh và yêu cầu riêng của dự án. Việc áp dụng cứng nhắc sẽ gây ảnh hưởng đến tính linh hoạt và khả năng mở rộng của phần mềm.
- **Cân nhắc hiệu quả:** Một số pattern đem lại sự linh hoạt nhưng cũng làm tăng độ phức tạp, giảm hiệu năng hệ thống. Do đó, hãy luôn cân nhắc giữa lợi ích và chi phí khi áp dụng chúng.
- **Học hỏi và rèn luyện**: Sử dụng thành thạo Design Pattern đòi hỏi quá trình học tập bài bản và kinh nghiệm thực tế. Lập trình viên cần chủ động tìm hiểu, nghiên cứu và vận dụng thường xuyên để nâng cao kỹ năng.
