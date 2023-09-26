package ch.tbz.animal.domain.user.dto;


import ch.tbz.animal.core.generic.AbstractDTO;

import java.util.UUID;

public class UserRegisterDTO extends AbstractDTO {

  private String username;

  private String password;
  public UserRegisterDTO() {
  }

  public UserRegisterDTO(UUID id, String username, String password) {
    super(id);
    this.username = username;
    this.password = password;
  }
}
