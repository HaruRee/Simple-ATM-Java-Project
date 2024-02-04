public class Main {
    public static void main(String[] args) {
        Account[] savingsAccounts = {
                new SavingsAccount(1, 1234, 5124000.0),
                new SavingsAccount(2, 123, 123000.0),
                new SavingsAccount(3, 3456, 7000.0)
        };
        Account[] checkingAccounts = {
                new CheckingAccount(1, 123, 8012400.0),
                new CheckingAccount(2, 123, 9012400.0),
                new CheckingAccount(3, 123, 11240000.0)
        };
        ATM atm = new ATM(savingsAccounts, checkingAccounts);
        atm.start();
    }
}
