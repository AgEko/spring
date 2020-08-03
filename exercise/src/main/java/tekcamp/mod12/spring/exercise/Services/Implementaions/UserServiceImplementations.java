package tekcamp.mod12.spring.exercise.Services.Implementaions;

import org.springframework.stereotype.Service;
import tekcamp.mod12.spring.exercise.DAOrepository.UserRepository;
import tekcamp.mod12.spring.exercise.Model.User;
import tekcamp.mod12.spring.exercise.Services.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementations implements UserService {

    private final UserRepository userRepository;

    public UserServiceImplementations(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        List<User> returnValue = new ArrayList<User>();
        returnValue = (List<User>) userRepository.findAll();
        return returnValue;
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        Optional<User> returnValue = userRepository.findById(id);
        return returnValue;
    }

    @Override
    public User getUserByEmailAddress(String email) {
        User returnValue = userRepository.findByEmailAddress(email);
        return returnValue;
    }

    @Override
    public void updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id).get();
        user.setEmailAddress(userDetails.getEmailAddress());
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setPassword(userDetails.getPassword());
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
        

}
