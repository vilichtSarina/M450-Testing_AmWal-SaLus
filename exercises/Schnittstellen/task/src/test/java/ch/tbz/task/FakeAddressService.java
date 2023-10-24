package ch.tbz.task;

import ch.tbz.task.address.Address;
import ch.tbz.task.address.AddressDAO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class FakeAddressService implements AddressDAO {
    private static final AtomicInteger counter = new AtomicInteger();
    private List<Address> addressList;

    public FakeAddressService(List<Address> addressList) {
        this.addressList = addressList;
        counter.set(addressList.size());
    }

    @Override
    public boolean isAvailable() {
        return addressList != null;
    }

    @Override
    public int getUniqueId() {
        return counter.getAndIncrement();
    }

    @Override
    public void create(Address address) {
        addressList.add(address);
    }

    @Override
    public Address read(int id) {
        return addressList.stream().filter(address -> address.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Address> readAll() {
        return addressList;
    }

    @Override
    public void update(Address oldAddress, Address address) {
        addressList.set(addressList.indexOf(oldAddress), address);
    }

    @Override
    public void delete(int id) {
        addressList.stream().filter(address -> address.getId() != id).collect(Collectors.toList());
    }
}
