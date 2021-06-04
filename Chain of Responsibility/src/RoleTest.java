public class RoleTest extends Test {
    @Override
    public boolean check(String email, String password) {
        System.out.println("Role Data");
        if (email.equals("admin@example.com")) {
            System.out.println("Hello, admin!");
            return true;
        }
        System.out.println("Hello, user!");
        return checkNext(email, password);
    }
}
