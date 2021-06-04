public abstract class Test {
    private Test next;

    public Test linkWith(Test next) {
        this.next = next;
        return next;
    }

    public abstract boolean check(String email, String password);


    protected boolean checkNext(String email, String password) {
        if (this.next == null) {
            return true;
        }
        return next.check(email, password);
    }
}
