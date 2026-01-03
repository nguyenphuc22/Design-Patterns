package design.patterns.creational.singleton;

/**
 * Phiên bản Singleton đơn giản (Naive Implementation).
 * 
 * Cách này dễ hiểu nhất:
 * - Kiểm tra nếu instance chưa có (null) thì tạo mới.
 * - Nếu có rồi thì trả về.
 * 
 * VẤN ĐỀ:
 * Cách này KHÔNG a toàn khi chạy đa luồng (Non Thread-safe).
 * Nếu 2 luồng cùng gọi getInstance() cùng lúc khi instance == null,
 * cả 2 sẽ cùng lọt vào trong và tạo ra 2 object khác nhau.
 */
public class BasicSingleton {

    private static BasicSingleton instance;
    private String value;

    private BasicSingleton(String value) {
        // Giả lập khởi tạo tốn thời gian để dễ thấy lỗi khi chạy đa luồng
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.value = value;
    }

    public static BasicSingleton getInstance(String value) {
        if (instance == null) {
            instance = new BasicSingleton(value);
        }
        return instance;
    }

    public String getValue() {
        return value;
    }
}
