package ch.tbz.animal.domain.role.dto;


import ch.tbz.animal.core.generic.AbstractMapper;
import ch.tbz.animal.domain.role.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper extends AbstractMapper<Role, RoleDTO> {
}
