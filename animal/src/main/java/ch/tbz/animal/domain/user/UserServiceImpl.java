package ch.tbz.animal.domain.user;

import ch.tbz.animal.core.generic.AbstractServiceImpl;
import ch.tbz.animal.domain.role.RoleService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
@Log4j2
@Service
public class UserServiceImpl extends AbstractServiceImpl<User> implements UserService {
    private final UserRepository userRepository;

    private static final String DOES_NOT_EXIST = " is non-existent";
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;


    @Autowired
    public UserServiceImpl(UserRepository repository, RoleService roleService, PasswordEncoder passwordEncoder,
                           UserRepository userRepository) {
        super(repository);
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
        this.userRepository = userRepository;
    }

    /**
     * Given an email address, this function tries to find a matching UserDetails object.
     * If no User is found, an exception is thrown.
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.info("Trying to load user with email: " + email);

        return ((UserRepository) repository).findByEmail(email)
                .map(UserDetailsImpl::new)
                .orElseThrow(() -> new UsernameNotFoundException(email));
    }

    /**
     * Used to register a new User.
     * By default, the new user will be assigned the role DEFAULT, along with a generated password.
     */
    @Override
    public User register(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(Collections.singletonList(roleService.getRoleByName("DEFAULT"))));
        log.warn("[PASSWORD for sarinaiscool]: " + passwordEncoder.encode(user.getPassword()));

        return save(user);
    }

    /**
     * Used to register a new User.
     * By default, the new user will be assigned the role DEFAULT, along with a password consisting of the full name.
     */
    @Override
    public User registerUser(User user) {

        user.setPassword(passwordEncoder.encode(user.getUsername()));
        user.setRoles(new HashSet<>(Collections.singletonList(roleService.getRoleByName("DEFAULT"))));

        return save(user);
    }

    /**
     * Updates the information of a User if the UserController PreAuthorize checks passed.
     * Roles and password will not be changed through this action.
     */
    @Override
    public User updateUserById(UUID id, User newUserData) {
        if (repository.existsById(id)) {

            User user = findById(id);
            user.setUsername(newUserData.getUsername());

            return repository.save(user);
        } else {
            String errorMessage = HttpStatus.NOT_FOUND + " User with id " + id + DOES_NOT_EXIST;
            log.warn(errorMessage);
            throw new NoSuchElementException(errorMessage);
        }
    }

    @Override
    public User getUserById(UUID userId) {
        return userRepository.findById(userId).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void deleteUserById(UUID userId) {

    }

    @Override
    public User getCurrentlyLoggedInUser() {
        return null;
    }
}
