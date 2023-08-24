package unitTest;

// right click class name, select "source action > generate tests"

public class BankAccount {
    double balance;
    String owner;

    public void deposit(double amount) {
        balance += amount;

    }

    public void withdraw(double amount) {
        balance -= amount;

    }
    
}
