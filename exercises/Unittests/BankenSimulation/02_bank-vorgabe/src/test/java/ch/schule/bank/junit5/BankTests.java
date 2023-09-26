package ch.schule.bank.junit5;

import ch.schule.Bank;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests f�r die Klasse 'Bank'.
 *
 * @author xxxx
 * @version 1.0
 */
public class BankTests {
    /**
     * Tests to create new Accounts
     */
    @Test
    public void testCreate() {
       Bank testBank = new Bank();
//        // 1. Konto der Migros Bank
//        testBank.createPromoYouthSavingsAccount();
//        // Einzahlung auf Migros Konto 24000
//        testBank.deposit("Y-1000",13456, 24000);
//        // Konto Saldo ausgeben
//        testBank.out.println("Saldo des Kontos Y-1000 ist: " + migros.getBalance("Y-1000")+" mmRp." );
//        // erstes Konto -> Saldo ausgeben
//        testBank.printTop5();
//        // letzes Konto -> Saldo ausgeben
//        testBank.printBottom5();
          assertNotNull(testBank);
    }
    /**
     * Testet das Einzahlen auf ein Konto.
     */
    @Test
    public void testDeposit() {
        fail("toDo");
    }
    /**
     * Testet das Abheben von einem Konto.
     */
    @Test
    public void testWithdraw() {
        fail("toDo");
    }

    /**
     * Experimente mit print().
     */
    @Test
    public void testPrint() {
        fail("toDo");
    }

    /**
     * Experimente mit print(year, month).
     */
    @Test
    public void testMonthlyPrint() {
        fail("toDo");
    }

    /**
     * Testet den Gesamtkontostand der Bank.
     */
    @Test
    public void testBalance() {
        fail("toDo");
    }

    /**
     * Tested die Ausgabe der "top 5" konten.
     */
    @Test
    public void testTop5() {
        fail("toDo");
    }

    /**
     * Tested die Ausgabe der "top 5" konten.
     */
    @Test
    public void testBottom5() {
        fail("toDo");
    }

}
