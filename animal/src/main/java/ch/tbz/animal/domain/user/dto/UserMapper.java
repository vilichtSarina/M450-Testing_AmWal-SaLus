package ch.tbz.animal.domain.user.dto;

import ch.tbz.animal.core.generic.AbstractMapper;
import ch.tbz.animal.domain.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends AbstractMapper<User, UserDTO> {
  User fromUserRegisterDTO(UserRegisterDTO dto);
}
