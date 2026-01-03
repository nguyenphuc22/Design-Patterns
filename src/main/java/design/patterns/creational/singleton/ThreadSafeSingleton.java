package design.patterns.creational.singleton;

/**
 * Thread-safe Singleton implementation using Double-Checked Locking.
 */
public class ThreadSafeSingleton {

    // Từ khóa volatile đảm bảo tính hiển thị (visibility) của các thay đổi đối với biến instance giữa các luồng.
    private static volatile ThreadSafeSingleton instance;

    // Dữ liệu ví dụ để chứng minh các instance là giống nhau
    private String value;

    // Constructor private để ngăn chặn việc khởi tạo từ bên ngoài
    private ThreadSafeSingleton(String value) {
        // Mô phỏng việc khởi tạo tốn kém thời gian
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.value = value;
    }

    public static ThreadSafeSingleton getInstance(String value) {
        // Cách tiếp cận này được gọi là Double-Checked Locking (Khóa kiểm tra hai lần).
        ThreadSafeSingleton result = instance;
        if (result != null) {
            return result;
        }
        synchronized (ThreadSafeSingleton.class) {
            if (instance == null) {
                instance = new ThreadSafeSingleton(value);
            }
            return instance;
        }
    }

    public String getValue() {
        return value;
    }
}
