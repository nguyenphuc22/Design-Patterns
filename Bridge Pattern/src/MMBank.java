public class MMBank extends Bank {

    public MMBank(Account account) {
        super(account);
    }

    @Override
    public void openAccount() {
        System.out.println("Chào mừng đến với MBBank");
        System.out.println("Welcome to MMBank");
        account.openAccount();
    }
}
