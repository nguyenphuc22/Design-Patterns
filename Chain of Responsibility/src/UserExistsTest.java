public class UserExistsTest extends Test{
    private Server server;

    public UserExistsTest(Server server) {
        this.server = server;
    }

    public boolean check(String email, String password) {
        System.out.println("User Exist");
        if (!server.hasEmail(email)) {
            System.out.println("This email is not registered!");
            return false;
        }

        return checkNext(email, password);
    }
}
