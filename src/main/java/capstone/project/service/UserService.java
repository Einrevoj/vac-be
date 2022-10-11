package capstone.project.service;

import capstone.project.dto.UserDTO;
import capstone.project.entity.UserEntity;
import capstone.project.exception.UserAlreadyExist;
import capstone.project.model.UserRequest;
import capstone.project.repository.UserRepository;
import capstone.project.util.DateTimeUtil;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final DateTimeUtil dateTimeUtil;
    private final ModelMapper modelMapper;


    public UserDTO saveUser(@NonNull UserRequest newUser) {

        // Check if email is existing
        if(userRepository.findByEmail(newUser.getEmail()) != null) {
            throw new UserAlreadyExist("Email already in used");
        }

        // Initialize user
        UserEntity user = UserEntity
                .builder()
                .userId(UUID.randomUUID())
                .firstName(newUser.getFirstName())
                .middleName(newUser.getMiddleName())
                .lastName(newUser.getLastName())
                .email(newUser.getEmail())
                .password(newUser.getPassword())
                .confirmPassword(newUser.getConfirmPassword())
                .createdDate(dateTimeUtil.currentDate())
                .modifiedDate(dateTimeUtil.currentDate())
                .build();

        // Save to database
        userRepository.save(user);

        return modelMapper.map(user, UserDTO.class);
    }
}
