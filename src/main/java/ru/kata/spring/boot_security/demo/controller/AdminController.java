package ru.kata.spring.boot_security.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;


import java.util.List;
@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping()
    public String showAll(ModelMap model) {
        List<User> users = userService.showUser();
        model.addAttribute("users", users);
        return "showAll";
    }

    @GetMapping("/showAll/{id}/info")
    public String info(@PathVariable("id") int id, ModelMap model) {
        model.addAttribute("users", userService.getUser(id));
        return "info";
    }
    @GetMapping("/newUser")
    public String addNewUser(ModelMap model) {
        model.addAttribute("users", new User());
        return "newUser";
    }
    @PostMapping()
    private String createUser(@ModelAttribute("users") User user){
        userService.saveUser(user);
        return "redirect:/admin";

    }
    @GetMapping("/showAll/{id}/edit")
    public String edit(Model model,@PathVariable("id") int id ) {
        model.addAttribute("user", userService.getUser(id));
        return "edit";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.updateUser(id, user);
        return "redirect:/admin";
    }
    @GetMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        userService.removeUser(id);
        return "redirect:/admin";

    }

}
