package ch.tbz.task.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    private AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAllAddresses() {
        return addressRepository.findAll().stream().sorted(new AddressComparator()).toList();
    }

    public Address registerAddress(Address address) {
        address.setRegistrationDate(new Date());
        return addressRepository.save(address);
    }

    public Optional<Address> getAddressById(Integer id) {
        return addressRepository.findById(id);
    }

    public Address clearAddressFields(Integer id) {
        Address address = getAddressById(id).orElseThrow();
        address.setFirstname("");
        address.setLastname("");
        address.setPhonenumber("");
        return addressRepository.save(address);
    }
}
