package ch.schule.bank.junit5;

import ch.schule.Account;
import ch.schule.SalaryAccount;
import ch.schule.SavingsAccount;
import org.junit.jupiter.api.Test;

import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests für die Klasse Account.
 *
 * @author xxxx
 * @version 1.0
 */
public class AccountTests {

    /**
     * Tested die Initialisierung eines Kontos.
     */
    @Test
    public void testInit() {
        Account account = new Account("12345");
        assertNotNull(account);
        assertEquals("12345", account.getId());
    }

    /**
     * Testet das Einzahlen auf ein Konto.
     */
    @Test
    public void testDeposit() {
        Account account = new Account("12345");
        assertTrue(account.deposit(20231024, 1000));
        assertEquals(1000, account.getBalance());
    }

    /**
     * Testet das Abheben von einem Konto.
     */
    @Test
    public void testWithdraw() {
        Account account = new Account("12345");
        account.deposit(20231024, 1000);
        assertTrue(account.withdraw(20231025, 500));
        assertEquals(500, account.getBalance());
    }

    /**
     * Tests the reference from SavingsAccount
     */
    @Test
    public void testReferences() {
        SavingsAccount savingsAccount = new SavingsAccount("54321");
        Account account = savingsAccount;
        assertNotNull(account);
        assertTrue(account instanceof SavingsAccount);
    }

    /**
     * teste the canTransact Flag
     */
    @Test
    public void testCanTransact() {
        Account account = new Account("12345");
        assertTrue(account.canTransact(20231024));
    }

    /**
     * Experimente mit print().
     */
    @Test
    public void testPrint() {
        Account account = new Account("12345");
        account.deposit(20231024, 1000);
        account.withdraw(20231025, 500);
        account.print();
    }

    /**
     * Experimente mit print(year,month).
     */
    @Test
    public void testMonthlyPrint() {
        Account account = new Account("12345");
        account.deposit(20231024, 1000);
        account.withdraw(20231025, 500);
        account.print(2023, 10);
    }

}
