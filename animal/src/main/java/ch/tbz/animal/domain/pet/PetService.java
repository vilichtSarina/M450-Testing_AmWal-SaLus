package ch.tbz.animal.domain.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class PetService {

    private final PetRepository petRepository;

    @Autowired
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public Pet getPetById(UUID id) {
        return petRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                String.format("Pet with id %s does not exist.", id)));
    }

    public Pet createPet(Pet pet) {
        petRepository.save(pet);
        return pet;
    }

    public Pet updatePetById(UUID id, Pet pet) {
        if (!petRepository.existsById(id)) {
            throw new NoSuchElementException("Pet with id " + id + " does not exist.");
        }
        return petRepository.save(pet);
    }
}
