package ch.tbz.animal.domain.authority.dto;

import ch.tbz.animal.core.generic.AbstractMapper;
import ch.tbz.animal.domain.authority.Authority;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthorityMapper extends AbstractMapper<Authority, AuthorityDTO> {
}

