package ch.bbw.addressbook;


import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AddressService {

	// field injectiuon for heavier testing
	// @Autowired
	private AddressRepository addressRepository;

	// constructor injection for easy to test
	public AddressService( AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}

	public List<Address> getAllAddresses() {
		List<Address> addresses = addressRepository.readAll();

		// TODO: Hier Sortierung einbauen

		// TODO: Order by lastname
//		// Einfache Sortiervariante ohne externen eigenständigen Comparator
//		addresses.sort( (a1, a2) -> {
//			return a1.getLastname().compareTo(a2.getLastname());
//		});

		addresses.sort(new LastnameFirstnameRegistrationDatecomparator());
		
		return addresses;
	}
	
	public void registerAddress(Address address) {
		// TODO: Hier Registrierungsdatum setzen
		address.setRegistrationDate(new Date());
		addressRepository.create(address);
	}

	public void setAddressDAO(AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}


	public boolean query(String query) {
		return addressRepository.isAvailable();
	}
	@Override
	public String toString() {
		return "Using database with id: " + String.valueOf(addressRepository.getUniqueId());
	}
}
