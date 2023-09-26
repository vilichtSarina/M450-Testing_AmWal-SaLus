package ch.tbz.animal.domain.role.dto;


import ch.tbz.animal.core.generic.AbstractDTO;
import ch.tbz.animal.domain.authority.dto.AuthorityDTO;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Set;
import java.util.UUID;

public class RoleDTO extends AbstractDTO {

  @NotNull
  private String name;

  private Set<AuthorityDTO> authorities;

  public RoleDTO() {
  }

  public RoleDTO(UUID id, String name, Set<AuthorityDTO> authorities) {
    super(id);
    this.name = name;
    this.authorities = authorities;
  }

  public String getName() {
    return name;
  }

  public RoleDTO setName(String name) {
    this.name = name;
    return this;
  }

  public Set<AuthorityDTO> getAuthorities() {
    return authorities;
  }

  public RoleDTO setAuthorities(Set<AuthorityDTO> authorities) {
    this.authorities = authorities;
    return this;
  }
}