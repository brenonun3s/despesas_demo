package br.com.gerenciadordespesas.despesas.controller;

import br.com.gerenciadordespesas.despesas.model.User;
import br.com.gerenciadordespesas.despesas.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
public class UserController {


    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User cadastrarUsuario(@RequestBody User user){
        User savedUser = userService.registerUser(user);
        return savedUser;
    }

}
