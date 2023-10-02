package ch.tbz.animal.domain.pet.dto;

import ch.tbz.animal.core.generic.AbstractMapper;
import ch.tbz.animal.domain.pet.Pet;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PetMapper extends AbstractMapper<Pet, PetDto> {

    @Override
    Pet fromDTO(PetDto dto);
}
