package ch.tbz.task.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("")
    public ResponseEntity<List<Address>> getAddresses() {
        return new ResponseEntity<>(addressService.getAllAddresses(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Address> getAddress(@PathVariable Integer id) {
        return new ResponseEntity<>(addressService.getAddressById(id).orElseThrow(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Address> postAddress(Address address) {
        addressService.registerAddress(address);
        return new ResponseEntity<>(address, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> clearFieldsById(@PathVariable Integer addressId) {
        Address address = addressService.clearAddressFields(addressId);
        return new ResponseEntity<>(address, HttpStatus.OK);
    }
}
