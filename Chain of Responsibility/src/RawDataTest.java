public class RawDataTest extends Test{
    @Override
    public boolean check(String email, String password) {
        System.out.println("Raw Data");
        if (!email.contains("@")) {
            System.out.println("Email Valid");
            return false;
        }
        return this.checkNext(email,password);
    }
}
