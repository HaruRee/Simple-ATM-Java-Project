import java.util.Scanner;

public class ATM {
    private Account[] savingsAccounts;
    private Account[] checkingAccounts;
    private Scanner scanner = new Scanner(System.in);

    public ATM(Account[] savingsAccounts, Account[] checkingAccounts) {
        this.savingsAccounts = savingsAccounts;
        this.checkingAccounts = checkingAccounts;
    }

    public void start() {
        while (true) {
            System.out.println("Choose account type:\n1. Savings\n2. Checking");
            int accountType = scanner.nextInt();
            System.out.println("Enter account number:");
            int accountId = scanner.nextInt();
            System.out.println("Enter pin:");
            int pin = scanner.nextInt();

            Account account = null;
            if (accountType == 1) {
                for (Account a : savingsAccounts) {
                    if (a.id == accountId && a.checkPin(pin)) {
                        account = a;
                        break;
                    }
                }
            } else if (accountType == 2) {
                for (Account a : checkingAccounts) {
                    if (a.id == accountId && a.checkPin(pin)) {
                        account = a;
                        break;
                    }
                }
            }

            if (account == null) {
                System.out.println("Invalid account or pin.");
                continue;
            }

            System.out.println("Choose transaction:\n1. Inquire Balance\n2. Withdraw\n3. Deposit\n4. Change Pin\n5. Transfer Money");
            int transaction = scanner.nextInt();
            switch (transaction) {
                case 1:
                    System.out.println("Balance: " + account.getBalance());
                    System.out.println("Transaction Summary: Inquired balance. Current balance: " + account.getBalance());
                    break;
                case 2:
                    System.out.println("Enter amount to withdraw:");
                    double amount = scanner.nextDouble();
                    account.withdraw(amount);
                    System.out.println("Withdrawn: " + amount);
                    System.out.println("Transaction Summary: Withdrew " + amount + ". Current balance: " + account.getBalance());
                    break;
                case 3:
                    System.out.println("Enter amount to deposit:");
                    amount = scanner.nextDouble();
                    account.deposit(amount);
                    System.out.println("Deposited: " + amount);
                    System.out.println("Transaction Summary: Deposited " + amount + ". Current balance: " + account.getBalance());
                    break;
                case 4:
                    System.out.println("Enter new pin:");
                    int newPin = scanner.nextInt();
                    account.changePin(newPin);
                    System.out.println("Pin changed.");
                    System.out.println("Transaction Summary: Pin changed.");
                    break;
                case 5:
                    System.out.println("Enter account number to transfer to:");
                    int toAccountId = scanner.nextInt();
                    Account toAccount = null;
                    if (accountType == 1) {
                        for (Account a : savingsAccounts) {
                            if (a.id == toAccountId) {
                                toAccount = a;
                                break;
                            }
                        }
                    } else if (accountType == 2) {
                        for (Account a : checkingAccounts) {
                            if (a.id == toAccountId) {
                                toAccount = a;
                                break;
                            }
                        }
                    }
                    if (toAccount == null) {
                        System.out.println("Invalid account to transfer to.");
                        break;
                    }
                    System.out.println("Enter amount to transfer:");
                    amount = scanner.nextDouble();
                    account.transfer(toAccount, amount);
                    System.out.println("Transaction Summary: Transferred " + amount + " to account: " + toAccountId + "\nCurrent balance: " + account.getBalance());
                    break;


            }

            System.out.println("Do another transaction? (yes/no)");
            String anotherTransaction = scanner.next();
            if (!anotherTransaction.equalsIgnoreCase("yes")) {
                break;
            }
        }
    }
}