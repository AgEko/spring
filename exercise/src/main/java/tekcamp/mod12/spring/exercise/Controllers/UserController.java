package tekcamp.mod12.spring.exercise.Controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import tekcamp.mod12.spring.exercise.DAOrepository.UserRepository;
import tekcamp.mod12.spring.exercise.DTO.UserDTO;
import tekcamp.mod12.spring.exercise.Model.Request.UserRequest;
import tekcamp.mod12.spring.exercise.Model.Response.UserResponse;
import tekcamp.mod12.spring.exercise.Model.User;
import tekcamp.mod12.spring.exercise.Services.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest userRequest) {
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userRequest, userDTO);
        UserDTO createdUser = userService.createUser(userDTO);
        UserResponse returnValue = new UserResponse();
        BeanUtils.copyProperties(createdUser, returnValue);

        return returnValue;
    }

    @GetMapping
    public List<UserResponse> getUsers(){
        List<User> userList = userService.getUsers();

        ArrayList<UserResponse> returnValue = new ArrayList<>();

        for (User user : userList){
            UserResponse userResponse = new UserResponse();
            BeanUtils.copyProperties(user, userResponse);

            returnValue.add(userResponse);
        }

        return returnValue;
    }

    @GetMapping(path = "/id/{id}")
    public UserResponse getUserById(@PathVariable Long id){
        User queriedUser = userService.getUserById(id);

        UserResponse returnValue = new UserResponse();
        BeanUtils.copyProperties(queriedUser, returnValue);

        return returnValue;
    }

    @GetMapping(path = "/emailAddress/{emailAddress}")
    public UserResponse getUserByEmailAddress(@PathVariable String email){
        User queriedUser = userService.getUserByEmailAddress(email.toLowerCase());

        UserResponse returnValue = new UserResponse();
        BeanUtils.copyProperties(queriedUser, returnValue);
        return returnValue;
    }

    @PutMapping(path = "/updateUser")
    public UserResponse updateUser(@RequestBody UserRequest userRequest) {
        User queriedUser = userService.getUserById(userRequest.getUserId());

        UserDTO foundUserDto = new UserDTO();
        BeanUtils.copyProperties(queriedUser, foundUserDto);

        UserDTO updatedUser = userService.updateUser(userRequest, foundUserDto);
        BeanUtils.copyProperties(updatedUser, queriedUser);

        User storedUserDetails = userRepository.save(queriedUser);

        UserResponse returnValue = new UserResponse();
        BeanUtils.copyProperties(storedUserDetails, returnValue);

        return returnValue;
    }


    @DeleteMapping(path = "/deleteUser")
    public void deleteUser(@RequestBody UserRequest userRequest) {

        User queriedUser = userService.getUserById(userRequest.getUserId());

        userRepository.delete(queriedUser);

    }

    @GetMapping(path = "/page={pageNum}pageMax={pageMax}")
    public List<UserResponse> getPaginatedUsers(@PathVariable int pageNumber, @PathVariable int pageMax) {
        List<User> paginatedUsers = userService.getPaginatedUsers(pageNumber, pageMax);
        ArrayList<UserResponse> returnValue = new ArrayList<>();

        for (User user : paginatedUsers) {
            UserResponse userResponse = new UserResponse();
            BeanUtils.copyProperties(user, userResponse);
            returnValue.add(userResponse);
        }
        return returnValue;
    }

}
