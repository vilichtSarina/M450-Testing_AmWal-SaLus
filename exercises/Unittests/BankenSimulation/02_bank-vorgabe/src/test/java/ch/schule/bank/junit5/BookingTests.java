package ch.schule.bank.junit5;

import ch.schule.Booking;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests für die Klasse Booking.
 */
public class BookingTests {
	/**
	 * Tests für die Erzeugung von Buchungen.
	 */
	@Test
	public void testInitialization() {
		Booking booking = new Booking(20231024, 1000);
		assertEquals(20231024, booking.getDate());
		assertEquals(1000, booking.getAmount());
	}

	/**
	 * Experimente mit print().
	 */
	@Test
	public void testPrint() {
		Booking booking = new Booking(20231024, 1000);
		long balance = 500;
		booking.print(balance);
		// Check if the print method runs without errors
	}
}
