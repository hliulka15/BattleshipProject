package unitTest;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BankAccountTest {
    BankAccount bankAccount;

    @Before public void setUp() throws Exception {
        bankAccount = new BankAccount();
    }

    @Test
    public void testDeposit() {
        bankAccount.deposit(100);
        assertEquals(100, bankAccount.balance, 0.0);
    }

    @Test
    public void testWithdraw() {
        bankAccount.deposit(1000);
        bankAccount.withdraw(100);
        bankAccount.deposit(10);
        assertEquals(910, bankAccount.balance, 0.0);
    }
}
