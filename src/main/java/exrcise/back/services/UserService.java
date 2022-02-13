package exrcise.back.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exrcise.back.entity.User;
import exrcise.back.repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String register(User user) {
        if (userExist(user.getUsername())) {
            return "This user already exists";
        }
        userRepository.save(user);
        return "User registered";
    }

    private boolean userExist(String username) {
        return userRepository.findByUsername(username) != null;
    }
}
