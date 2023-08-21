package ru.javamentor.springBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.javamentor.springBoot.model.User;
import ru.javamentor.springBoot.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String showUsers(Model model) {
        List<User> listOfUsers = userService.getAllUsers();
        model.addAttribute("users", listOfUsers);
        return "users";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());

        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}")
    public String showOneUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.findUser(id));
        return "user";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable("id") long id, Model model) {
        User user = userService.findUser(id);
        model.addAttribute("user", user);
        return "edit";
    }

    @PostMapping("/{id}/edit")
    public String updateUser(@PathVariable("id") long id, @ModelAttribute("user") User updatedUser) {
        userService.updateUser(id, updatedUser.getFirstName(), updatedUser.getLastName(), updatedUser.getAge());
        return "redirect:/users";
    }

    @GetMapping("/{id}/delete")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }
}
