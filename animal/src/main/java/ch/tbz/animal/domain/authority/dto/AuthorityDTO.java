package ch.tbz.animal.domain.authority.dto;

import ch.tbz.animal.core.generic.AbstractDTO;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.UUID;

public class AuthorityDTO extends AbstractDTO {

  @NotNull
  private String name;

  public AuthorityDTO() {
  }

  public AuthorityDTO(UUID id, String name) {
    super(id);
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public AuthorityDTO setName(String name) {
    this.name = name;
    return this;
  }

}
