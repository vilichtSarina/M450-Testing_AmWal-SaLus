package ch.tbz.task.address;

import java.util.Comparator;

public class AddressComparator implements Comparator<Address> {

    @Override
    public int compare(Address a1, Address a2) {
        // Compare by lastname
        int lastNameCompare = a1.getLastname().compareTo(a2.getLastname());
        if (lastNameCompare != 0) {
            return lastNameCompare;
        }

        // Compare by firstname
        int firstNameCompare = a1.getFirstname().compareTo(a2.getFirstname());
        if (firstNameCompare != 0) {
            return lastNameCompare;
        }

        // Compare by phone number
        int phoneNumberCompare = a1.getPhonenumber().compareTo(a2.getPhonenumber());
        if (phoneNumberCompare != 0) {
            return phoneNumberCompare;
        }

        // Compare by firstname if lastname is the same
        return a1.getRegistrationDate().compareTo(a2.getRegistrationDate());
    }

}
