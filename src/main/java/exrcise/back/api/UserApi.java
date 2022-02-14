package exrcise.back.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exrcise.back.entity.User;
import exrcise.back.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserApi {

    private UserService userService;

    @Autowired
    public UserApi(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin
    @PostMapping("/register")
    public String register(@RequestBody @Valid User user) {
        return userService.register(user);
    }

}
