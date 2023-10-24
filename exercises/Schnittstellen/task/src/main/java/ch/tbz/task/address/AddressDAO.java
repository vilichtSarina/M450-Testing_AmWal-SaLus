package ch.tbz.addressbook;

import java.util.List;

public interface AddressDAO {

    // for testing
    public boolean isAvailable();

    public int getUniqueId();

    // CRUD Commands: Create Read Update Delete
    public void create(Address address);

    public Address read(int id);

    public List<Address> readAll();

    public void update(Address oldAddress, Address address);

    public void delete(int id);

}