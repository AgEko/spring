package tekcamp.mod12.spring.exercise.Services.Implementaions;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import tekcamp.mod12.spring.exercise.DAOrepository.UserRepository;
import tekcamp.mod12.spring.exercise.DTO.UserDTO;
import tekcamp.mod12.spring.exercise.Model.Request.UserRequest;
import tekcamp.mod12.spring.exercise.Model.User;
import tekcamp.mod12.spring.exercise.Services.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImplementations implements UserService {

    private final UserRepository userRepository;


    public UserServiceImplementations(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User newUser = new User();
        BeanUtils.copyProperties(userDTO, newUser);
        User tempUserDetails = userRepository.save(newUser);
        UserDTO returnValue = new UserDTO();
        BeanUtils.copyProperties(tempUserDetails, returnValue);

        return returnValue;
    }

    @Override
    public List<User> getUsers() {
        List<User> returnValue = new ArrayList<User>();
        returnValue = (List<User>) userRepository.findAll();
        return returnValue;
    }


    @Override
    public User getUserById(Long id) {
        User returnValue = userRepository.findByUserId(id);
        return returnValue;
    }

    @Override
    public User getUserByEmailAddress(String email) {
        User returnValue = userRepository.findByEmailAddress(email);
        return returnValue;
    }

    @Override
    public UserDTO updateUser(UserRequest userRequest, UserDTO foundUserDTO) {
        foundUserDTO.setFirstName(userRequest.getFirstName());
        foundUserDTO.setLastName(userRequest.getLastName());
        foundUserDTO.setEmail(userRequest.getEmail());

        return foundUserDTO;
    }




}
