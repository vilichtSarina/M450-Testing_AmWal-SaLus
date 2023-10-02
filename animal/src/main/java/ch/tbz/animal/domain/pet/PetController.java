package ch.tbz.animal.domain.pet;

import ch.tbz.animal.domain.pet.dto.PetDto;
import ch.tbz.animal.domain.pet.dto.PetMapper;
import ch.tbz.animal.domain.user.User;
import ch.tbz.animal.domain.user.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/pet")
public class PetController {

    public final PetService petService;
    private final PetMapper petMapper;

    @Autowired
    public PetController(PetService petService, PetMapper petMapper) {
        this.petService = petService;
        this.petMapper = petMapper;
    }

    @GetMapping("/{petId}")
    public ResponseEntity<Pet> getPetById(@PathVariable("petId") UUID petId) {
        return new ResponseEntity<>(petService.getPetById(petId), HttpStatus.OK);
    }

    @PostMapping({"/", ""})
    public ResponseEntity<Pet> postPet(@RequestBody Pet pet) {
        petService.createPet(pet);
        return new ResponseEntity<>(pet, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PetDto> putById(@PathVariable UUID id, @RequestBody PetDto petDto) {
        Pet pet = petService.updatePetById(id, petMapper.fromDTO(petDto));
        return new ResponseEntity<>(petMapper.toDTO(pet), HttpStatus.OK);
    }
}
