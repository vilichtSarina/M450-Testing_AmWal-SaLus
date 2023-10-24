package ch.schule.bank.junit5;

import ch.schule.PromoYouthSavingsAccount;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PromoYouthSavingsAccountTest {

	@Test
	void testDeposit() {
		PromoYouthSavingsAccount account = new PromoYouthSavingsAccount("12345");
		assertTrue(account.deposit(20231024, 1000));
		assertEquals(1010, account.getBalance());
	}
}

