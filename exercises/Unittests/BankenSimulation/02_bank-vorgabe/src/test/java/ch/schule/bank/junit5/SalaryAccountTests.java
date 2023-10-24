package ch.schule.bank.junit5;

import ch.schule.SalaryAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests der Klasse SalaryAccount.
 */
public class SalaryAccountTests
{
	@Test
	void testWithdraw() {
		SalaryAccount account = new SalaryAccount("12345", -1000);
		account.deposit(20231024, 2000);
		assertTrue(account.withdraw(20231025, 500));
	}
}
