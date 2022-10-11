package capstone.project.controller;

import capstone.project.dto.UserDTO;
import capstone.project.model.UserRequest;
import capstone.project.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PutMapping("/signup")
    public UserDTO registerUser(@RequestBody @NonNull UserRequest userRequest) {
        return userService.saveUser(userRequest);
    }


}
