package ch.tbz.animal.domain.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/pet")
public class PetController {

    public final PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/{petId}")
    public ResponseEntity<Pet> getPetById(@PathVariable("petId") UUID petId) {
        return new ResponseEntity<>(petService.getPetById(petId), HttpStatus.OK);
    }

    @PostMapping({"/", ""})
    public ResponseEntity<Pet> createImagePost(@RequestBody Pet pet) {
        petService.createPet(pet);
        return new ResponseEntity<>(pet, HttpStatus.CREATED);
    }
}
