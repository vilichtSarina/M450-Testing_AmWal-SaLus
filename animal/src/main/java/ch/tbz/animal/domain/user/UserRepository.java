package ch.tbz.animal.domain.user;

import ch.tbz.animal.core.generic.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends AbstractRepository<User> {
  Optional<User> findByUsername(String username);
}
