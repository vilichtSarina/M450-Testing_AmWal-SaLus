package ch.schule.bank.junit5;

import ch.schule.Bank;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests für die Klasse 'Bank'.
 */
public class BankTests {
    /**
     * Tests to create new Accounts
     */
    @Test
    public void testCreate() {
        Bank bank = new Bank();
        assertNotNull(bank.createSavingsAccount());
        assertNotNull(bank.createPromoYouthSavingsAccount());
        assertNotNull(bank.createSalaryAccount(-1000));
    }

    /**
     * Testet das Einzahlen auf ein Konto.
     */
    @Test
    public void testDeposit() {
        Bank bank = new Bank();
        String accountId = bank.createSavingsAccount();
        assertTrue(bank.deposit(accountId, 20231024, 1000));
        assertEquals(1000, bank.getBalance(accountId));
    }

    /**
     * Testet das Abheben von einem Konto.
     */
    @Test
    public void testWithdraw() {
        Bank bank = new Bank();
        String accountId = bank.createSavingsAccount();
        bank.deposit(accountId, 20231024, 1000);
        assertTrue(bank.withdraw(accountId, 20231025, 500));
        assertEquals(500, bank.getBalance(accountId));
    }

    /**
     * Experimente mit print().
     */
    @Test
    public void testPrint() {
        Bank bank = new Bank();
        String accountId = bank.createSavingsAccount();
        bank.deposit(accountId, 20231024, 1000);
        bank.print(accountId);
        // Check if print method runs without errors
    }

    /**
     * Experimente mit print(year, month).
     */
    @Test
    public void testMonthlyPrint() {
        Bank bank = new Bank();
        String accountId = bank.createSavingsAccount();
        bank.deposit(accountId, 20231024, 1000);
        bank.print(accountId, 2023, 10);
        // Check if print monthly method runs without errors
    }

    /**
     * Testet den Gesamtkontostand der Bank.
     */
    @Test
    public void testBalance() {
        Bank bank = new Bank();
        bank.createSavingsAccount();
        bank.createPromoYouthSavingsAccount();
        bank.createSalaryAccount(-500);
        assertEquals(0, bank.getBalance());
    }

    /**
     * Tested die Ausgabe der "top 5" Konten.
     */
    @Test
    public void testTop5() {
        Bank bank = new Bank();
        for (int i = 0; i < 6; i++) {
            String accountId = bank.createSavingsAccount();
            bank.deposit(accountId, 20231024, i * 1000);
        }
        bank.printTop5();
        // Check if printTop5 method runs without errors
    }

    /**
     * Tested die Ausgabe der "bottom 5" Konten.
     */
    @Test
    public void testBottom5() {
        Bank bank = new Bank();
        for (int i = 0; i < 6; i++) {
            String accountId = bank.createSavingsAccount();
            bank.deposit(accountId, 20231024, i * 1000);
        }
        bank.printBottom5();
        // Check if printBottom5 method runs without errors
    }
}
