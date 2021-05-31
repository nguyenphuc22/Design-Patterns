public class TPBank extends Bank {

    public TPBank(Account account) {
        super(account);
    }

    @Override
    public void openAccount() {
        System.out.println("Chào mừng đến với TPBank");
        System.out.println("Welcome to TPBank");
        this.account.openAccount();
    }
}
