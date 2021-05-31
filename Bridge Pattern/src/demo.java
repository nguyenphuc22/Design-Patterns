public class demo {
    public static void main(String[] args) {
        Bank bank = new TPBank(new TutorialAccount());
        bank.openAccount();
        System.out.println();
        bank = new TPBank(new CheckingAccount());
        bank.openAccount();
        System.out.println();
        bank = new MMBank(new TutorialAccount());
        bank.openAccount();
    }
}
