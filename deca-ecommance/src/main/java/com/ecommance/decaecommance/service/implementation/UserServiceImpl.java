package com.ecommance.decaecommance.service.implementation;
import com.ecommance.decaecommance.dto.request.UserRequestDto;
import com.ecommance.decaecommance.dto.response.UserResponseDto;
import com.ecommance.decaecommance.model.User;
import com.ecommance.decaecommance.repository.UserRepository;
import com.ecommance.decaecommance.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {



    private final UserRepository userRepository;

    @Override
    public UserResponseDto createUser(UserRequestDto request) {
        User user = new User();
        user.setName(request.getName());
        user.setAge(request.getAge());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());

        User saveUser = userRepository.save(user);

        return new UserResponseDto( saveUser.getName(), saveUser.getRole(), saveUser.getAge());
    }

    @Override
    public UserResponseDto getUserById(Long userId) {

        User saveUser = userRepository.findById(userId).get();
        return new UserResponseDto(saveUser.getName(), saveUser.getRole(), saveUser.getAge());
    }

    @Override
    public UserResponseDto updateUser(Long userId, UserRequestDto request) {
        //Get and Set
        User userToUpdated = userRepository.findById(userId).get();

        userToUpdated.setName(request.getName());
        userToUpdated.setAge(request.getAge());
        userToUpdated.setPassword(request.getPassword());

        User saveUser = userRepository.save(userToUpdated);
        return new UserResponseDto(saveUser.getName(), saveUser.getRole(), saveUser.getAge());
    }

    @Override
    public void deleteUser(Long userId) {

        userRepository.deleteById(userId);
    }
}
