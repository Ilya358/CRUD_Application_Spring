package web.controller;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import web.service.UserService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
@ToString
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("userList")
    public ModelAndView getUserList() {
        List<User> list = userService.listUsers();
        ModelAndView model = new ModelAndView("userList");
        model.addObject("list", list);
        return model;
    }

    @RequestMapping("addUser")
    public String getAddUser(Map<String, Object> model) {
        User user = new User();
        model.put("user", user);
        return "addUser";
    }

    @RequestMapping(value = "submit", method = RequestMethod.POST)
    public String postAddUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/userList";
    }
    @RequestMapping("updateUser")
    public ModelAndView updateUser(@RequestParam long id) {
        ModelAndView modelAndView = new ModelAndView("updateUser");
        User user = userService.getUserById(id);
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping("deleteUser")
    public String deleteUser(@RequestParam long id) {
        userService.deleteUser(id);
        return "redirect:/userList";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/userList";
    }
}
