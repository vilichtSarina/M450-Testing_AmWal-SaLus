package ch.tbz.animal.domain.user.dto;

import ch.tbz.animal.domain.user.User;
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
public class UserMapperImpl implements UserMapper {

    @Override
    public User fromDTO(UserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setId( dto.getId() );

        return user;
    }

    @Override
    public List<User> fromDTOs(List<UserDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( dtos.size() );
        for ( UserDTO userDTO : dtos ) {
            list.add( fromDTO( userDTO ) );
        }

        return list;
    }

    @Override
    public Set<User> fromDTOs(Set<UserDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        Set<User> set = new HashSet<User>( Math.max( (int) ( dtos.size() / .75f ) + 1, 16 ) );
        for ( UserDTO userDTO : dtos ) {
            set.add( fromDTO( userDTO ) );
        }

        return set;
    }

    @Override
    public UserDTO toDTO(User BO) {
        if ( BO == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( BO.getId() );

        return userDTO;
    }

    @Override
    public List<UserDTO> toDTOs(List<User> BOs) {
        if ( BOs == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( BOs.size() );
        for ( User user : BOs ) {
            list.add( toDTO( user ) );
        }

        return list;
    }

    @Override
    public Set<UserDTO> toDTOs(Set<User> BOs) {
        if ( BOs == null ) {
            return null;
        }

        Set<UserDTO> set = new HashSet<UserDTO>( Math.max( (int) ( BOs.size() / .75f ) + 1, 16 ) );
        for ( User user : BOs ) {
            set.add( toDTO( user ) );
        }

        return set;
    }

    @Override
    public User fromUserRegisterDTO(UserRegisterDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setId( dto.getId() );

        return user;
    }
}