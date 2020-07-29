package tekcamp.mod12.spring.exercise.Controllers;

import org.springframework.web.bind.annotation.*;
import tekcamp.mod12.spring.exercise.Model.User;
import tekcamp.mod12.spring.exercise.Services.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public List<User> getUsers(){
        List<User> returnValue = userService.getUsers();
        return returnValue;
    }

    @GetMapping(path = "/id/{id}")
    public Optional<User> getUserById(@PathVariable Long id){
        Optional<User> returnValue = userService.getUserById(id);
        return returnValue;
    }

    @GetMapping(path = "/emailAddress/{emailAddress}")
    public User getUserByEmailAddress(@PathVariable String email){
        User returnValue = userService.getUserByEmailAddress(email);
        return returnValue;
    }


    @PostMapping
    public void createUser(@RequestBody User user){
        userService.createUser(user);
    }

    @PutMapping(path = "/id/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody User userProperties){
        userService.updateUser(id, userProperties);
    }

    @DeleteMapping(path = "/id/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

}
