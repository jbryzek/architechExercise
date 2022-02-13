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

    public User register(User user) {
        if (userExist(user.getUsername())) {
            System.out.println("User exist");
        }
        return userRepository.save(user);
    }

    private boolean userExist(String username) {
        return userRepository.findByUsername(username) != null;
    }
}
