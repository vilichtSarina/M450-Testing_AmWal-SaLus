package ch.tbz.animal.domain.user;

import ch.tbz.animal.core.generic.AbstractService;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.UUID;

public interface UserService extends UserDetailsService, AbstractService<User> {
  User register(User user);

  User registerUser(User user);

  User updateUserById(UUID id, User user);

  User getUserById(UUID userId);

  void deleteUserById(UUID userId);

  User getCurrentlyLoggedInUser();

  List<User> findAll();
}
