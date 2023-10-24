package ch.schule.bank.junit5;

import ch.schule.SavingsAccount;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests fuer die Klasse SavingsAccount.
 */
public class SavingsAccountTests {

	@Test
	void testWithdrawSufficientFunds() {
		SavingsAccount account = new SavingsAccount("12345");
		account.deposit(20231024, 2000);
		assertTrue(account.withdraw(20231025, 500));
	}

	@Test
	void testWithdrawInsufficientFunds() {
		SavingsAccount account = new SavingsAccount("12345");
		account.deposit(20231024, 2000);
		assertFalse(account.withdraw(20231025, 3000));
	}
}

