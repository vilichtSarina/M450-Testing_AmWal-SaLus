package ch.tbz.animal.domain.user;


import ch.tbz.animal.domain.user.dto.UserDTO;
import ch.tbz.animal.domain.user.dto.UserMapper;
import ch.tbz.animal.domain.user.dto.UserRegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Validated
@RestController
@RequestMapping("/api/users")
public class UserController {

  private final UserService userService;
  private final UserMapper userMapper;

  @Autowired
  public UserController(UserService userService, UserMapper userMapper) {
    this.userService = userService;
    this.userMapper = userMapper;
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserDTO> retrieveById(@PathVariable UUID id) {
    User user = userService.findById(id);
    return new ResponseEntity<>(userMapper.toDTO(user), HttpStatus.OK);
  }

    @GetMapping({"", "/"})
    public ResponseEntity<List<UserDTO>> retrieveAll() {
        List<User> users = userService.findAll();
        return new ResponseEntity<>(userMapper.toDTOs(users), HttpStatus.OK);
    }


  @PostMapping("/register")
  public ResponseEntity<UserDTO> register(@RequestBody UserRegisterDTO userRegisterDTO) {
    User user = userService.register(userMapper.fromUserRegisterDTO(userRegisterDTO));
    return new ResponseEntity<>(userMapper.toDTO(user), HttpStatus.CREATED);
  }

  @PostMapping("/registerUser")
  public ResponseEntity<UserDTO> registerWithoutPassword( @RequestBody UserDTO userDTO) {
    User user = userService.registerUser(userMapper.fromDTO(userDTO));
    return new ResponseEntity<>(userMapper.toDTO(user), HttpStatus.CREATED);
  }


  @PutMapping("/{id}")
  public ResponseEntity<UserDTO> updateById(@PathVariable UUID id, @RequestBody UserDTO userDTO) {
    User user = userService.updateUserById(id, userMapper.fromDTO(userDTO));
    return new ResponseEntity<>(userMapper.toDTO(user), HttpStatus.OK);
  }


  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
    userService.deleteUserById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
