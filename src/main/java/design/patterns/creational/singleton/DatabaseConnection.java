package design.patterns.creational.singleton;

/**
 * Ví dụ thực tế: Giả lập một kết nối cơ sở dữ liệu.
 * Trong thực tế, việc tạo kết nối DB rất tốn kém tài nguyên, nên thường được quản lý bằng Singleton.
 */
public class DatabaseConnection {

    private static DatabaseConnection instance;
    private boolean isConnected = false;

    private DatabaseConnection() {
        // Constructor private
    }

    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void connect() {
        if (!isConnected) {
            System.out.println("Đang kết nối đến Database...");
            // Giả lập thời gian kết nối
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            isConnected = true;
            System.out.println("Đã kết nối thành công!");
        } else {
            System.out.println("Đã có kết nối tồn tại.");
        }
    }

    public void executeQuery(String query) {
        if (isConnected) {
            System.out.println("Thực thi câu lệnh SQL: " + query);
        } else {
            System.out.println("Chưa kết nối đến Database! Vui lòng gọi connect() trước.");
        }
    }

    public void disconnect() {
        if (isConnected) {
            System.out.println("Đang ngắt kết nối...");
            isConnected = false;
            System.out.println("Đã ngắt kết nối.");
        }
    }
}
