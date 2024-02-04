public abstract class Account {
    protected int id;
    protected int pin;
    protected double balance;

    public Account(int id, int pin, double balance) {
        this.id = id;
        this.pin = pin;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void changePin(int newPin) {
        pin = newPin;
    }

    public boolean checkPin(int inputPin) {
        return pin == inputPin;
    }

    public void transfer(Account toAccount, double amount) {
        if (balance >= amount) {
            balance -= amount;
            toAccount.deposit(amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}