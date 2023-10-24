package ch.tbz.animal.domain.pet.dto;

import ch.tbz.animal.domain.pet.Pet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-03T11:04:16+0200",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.2.1.jar, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class PetMapperImpl implements PetMapper {

    @Override
    public List<Pet> fromDTOs(List<PetDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Pet> list = new ArrayList<Pet>( dtos.size() );
        for ( PetDto petDto : dtos ) {
            list.add( fromDTO( petDto ) );
        }

        return list;
    }

    @Override
    public Set<Pet> fromDTOs(Set<PetDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        Set<Pet> set = new HashSet<Pet>( Math.max( (int) ( dtos.size() / .75f ) + 1, 16 ) );
        for ( PetDto petDto : dtos ) {
            set.add( fromDTO( petDto ) );
        }

        return set;
    }

    @Override
    public PetDto toDTO(Pet BO) {
        if ( BO == null ) {
            return null;
        }

        PetDto petDto = new PetDto();

        petDto.setId( BO.getId() );

        return petDto;
    }

    @Override
    public List<PetDto> toDTOs(List<Pet> BOs) {
        if ( BOs == null ) {
            return null;
        }

        List<PetDto> list = new ArrayList<PetDto>( BOs.size() );
        for ( Pet pet : BOs ) {
            list.add( toDTO( pet ) );
        }

        return list;
    }

    @Override
    public Set<PetDto> toDTOs(Set<Pet> BOs) {
        if ( BOs == null ) {
            return null;
        }

        Set<PetDto> set = new HashSet<PetDto>( Math.max( (int) ( BOs.size() / .75f ) + 1, 16 ) );
        for ( Pet pet : BOs ) {
            set.add( toDTO( pet ) );
        }

        return set;
    }

    @Override
    public Pet fromDTO(PetDto dto) {
        if ( dto == null ) {
            return null;
        }

        Pet pet = new Pet();

        pet.setId( dto.getId() );

        return pet;
    }
}