package capstone.project.controller;

import capstone.project.dto.UserDTO;
import capstone.project.model.UserRequest;
import capstone.project.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PutMapping("/signup")
    public UserDTO registerUser(@RequestBody @NonNull UserRequest userRequest) {
        return userService.saveUser(userRequest);
    }
    @PostMapping("/login")
    public UserDTO loginUser(@RequestBody @NonNull UserRequest userRequest) {
        return userService.loginUser(userRequest);
    }

    @PostMapping("/loginByProvider/{email}")
    public UserDTO loginByProvider(@PathVariable String email) {
        return userService.loginByProvider(email);
    }

    @DeleteMapping("/{email}")
    public String deleteUser(@PathVariable String email) {
        return userService.deleteUser(email);
    }

    @PostMapping("/update/{oldEmail}")
    public UserDTO updateUser(@PathVariable String oldEmail, @RequestBody UserRequest userRequest) {
        return userService.updateUser(oldEmail, userRequest);
    }


}
