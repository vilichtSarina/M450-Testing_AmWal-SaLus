package ch.tbz.addressbook;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class AddressComparerTest {
    @Test
    public void sortsBiggerThan() {
        Instant currentTime =  Instant.now();
        Address bigger = new Address(1, "AAA", "AAA", "0000", Date.from(currentTime));
        Address smaller = new Address(2, "BBB", "BBB", "1111", Date.from(currentTime));

        assertEquals(1, new AddressComparator().compare(smaller, bigger));
    }

    @Test
    public void sortsSmallerThan() {
        Instant currentTime =  Instant.now();
        Address bigger = new Address(1, "AAA", "AAA", "0000", Date.from(currentTime));
        Address smaller = new Address(2, "BBB", "BBB", "1111", Date.from(currentTime));

        assertEquals(-1, new AddressComparator().compare(bigger, smaller));
    }


    @Test
    public void sortByPhoneNumber() {
        Instant currentTime =  Instant.now();
        Address bigger = new Address(1, "AAA", "AAA", "0000", Date.from(currentTime));
        Address smaller = new Address(1, "AAA", "AAA", "0001", Date.from(currentTime));

        assertEquals(-1, new AddressComparator().compare(bigger, smaller));
    }

    @Test
    public void sortsEqual() {
        Instant currentTime =  Instant.now();
        Address bigger = new Address(1, "AAA", "AAA", "0000", Date.from(currentTime));

        assertEquals(0, new AddressComparator().compare(bigger, bigger));
    }
}
