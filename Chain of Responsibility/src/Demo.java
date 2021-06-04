public class Demo {
    public static void main(String[] args) {
        Server server = new Server();
        server.register("admin@example.com", "admin_pass");
        server.register("phuc@xample.com", "user_pass");

        Test test = new RawDataTest();
        test.linkWith(new UserExistsTest(server)).linkWith(new RoleTest());

        server.setTest(test);

        server.logIn("phuc@xample.com","user_pass");
        System.out.println();
        server.logIn("phucxample.com","user_pass");
        System.out.println();
        server.logIn("admin@example.com", "admin_pass");

    }
}
