package tekcamp.mod12.spring.exercise.Services;

import tekcamp.mod12.spring.exercise.Model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getUsers();

    void createUser(User user);
    Optional<User> getUserById(Long id);
    User getUserByEmailAddress(String email);
    void updateUser(Long id, User userProperties);
    void deleteUser(Long id);
}
