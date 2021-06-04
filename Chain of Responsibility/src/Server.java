import java.util.HashMap;
import java.util.Map;

public class Server {
    private Map<String, String> users = new HashMap<>();
    private Test test;

    public void setTest(Test test) {
        this.test = test;
    }

    public boolean hasEmail(String email) {
        return users.containsKey(email);
    }

    public void register(String email, String password) {
        users.put(email, password);
    }

    public boolean logIn(String email, String password) {
        if (this.test.check(email, password)) {
            System.out.println("Authorization have been successful!");

            // Do something useful here for authorized users.

            return true;
        }
        System.out.println("Authorization have been fail!");
        return false;
    }
}
