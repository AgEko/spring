package tekcamp.mod12.spring.exercise.Services;

import tekcamp.mod12.spring.exercise.DTO.UserDTO;
import tekcamp.mod12.spring.exercise.Model.Request.UserRequest;
import tekcamp.mod12.spring.exercise.Model.User;

import java.util.List;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);

    List<User> getUsers();
    User getUserById(Long id);
    User getUserByEmailAddress(String email);

    UserDTO updateUser(UserRequest userRequest, UserDTO foundUserDto);


//    void updateUser(Long id, User userProperties);
//    void deleteUser(Long id);
}
