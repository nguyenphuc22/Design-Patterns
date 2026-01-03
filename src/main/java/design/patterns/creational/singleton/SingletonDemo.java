package design.patterns.creational.singleton;

public class SingletonDemo {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("   DEMO 1: Basic Singleton (Cố tình làm lỗi)   ");
        System.out.println("==========================================");
        
        // Chạy đa luồng với BasicSingleton để thấy lỗi (Race Condition)
        Runnable taskBasic = () -> {
            BasicSingleton singleton = BasicSingleton.getInstance(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getName() + " nhận được: " + singleton.getValue() + " | Hash: " + singleton.hashCode());
        };

        Thread threadBasic1 = new Thread(taskBasic, "Thread-Basic-1");
        Thread threadBasic2 = new Thread(taskBasic, "Thread-Basic-2");

        threadBasic1.start();
        threadBasic2.start();

        try {
            threadBasic1.join();
            threadBasic2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("=> Bạn có thể thấy HashCode khác nhau (tức là 2 object khác nhau) nếu xảy ra race condition.");        
        
        System.out.println("\n(Để an toàn, chúng ta reset instance về null nếu có thể, hoặc bỏ qua bước này trong code thực tế)");
        
        System.out.println("\n==========================================");
        System.out.println("   DEMO 2: Thread-Safe Singleton (Đa luồng)  ");
        System.out.println("==========================================");

        // Test Singleton Thread-Safe
        Thread thread1 = new Thread(() -> {
            ThreadSafeSingleton singleton = ThreadSafeSingleton.getInstance("LUONG_1");
            System.out.println("Thread 1 nhận được: " + singleton.getValue());
        });

        Thread thread2 = new Thread(() -> {
            ThreadSafeSingleton singleton = ThreadSafeSingleton.getInstance("LUONG_2");
            System.out.println("Thread 2 nhận được: " + singleton.getValue());
        });

        thread1.start();
        thread2.start();

        // Chờ các luồng kết thúc
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n==========================================");
        System.out.println("   DEMO 3: Real World (DatabaseConnection) ");
        System.out.println("==========================================");

        DatabaseConnection db1 = DatabaseConnection.getInstance();
        db1.connect();
        
        System.out.println("Done!");
    }
}
