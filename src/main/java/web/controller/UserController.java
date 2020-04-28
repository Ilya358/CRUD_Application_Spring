package web.controller;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.Role;
import web.model.User;
import web.service.RoleService;
import web.service.UserService;

import java.util.*;

@Controller
@RequestMapping("/")
@ToString
public class UserController {

    private final UserService userService;
    public final RoleService roleService;

    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("registration")
    public String registrationPage(Map<String, Object> model) {
        User user = new User();
        model.put("user", user);
        return "registration";
    }

    @GetMapping("admin/userList")
    public String getUserList(ModelMap model) {
        List<User> list = userService.listUsers();
        model.addAttribute("list", list);
        return "userList";
    }

    @GetMapping("admin/addUser")
    public String getAddUser(Map<String, Object> model, ModelMap modelMap) {
        User user = new User();
        model.put("user", user);
        modelMap.addAttribute("roleList", roleService.roleList());
        return "addUser";
    }

    @PostMapping("admin/submit")
    public String postAddUser(@ModelAttribute("user") User user, @RequestParam ArrayList<String> role) {
        Set<Role> roleSet = new HashSet<>();
        for (String roleId : role) {
            roleSet.add(roleService.getById(Long.valueOf(roleId)));
        }
        user.setRoles(roleSet);
        userService.add(user);
        return "redirect:/admin/userList";
    }

    @PostMapping("reg")
    public String postRegUser(@ModelAttribute("user") User user, String role) {
        String[] rolesArray;
        rolesArray = role.split(",");
        Set<Role> roles = new HashSet<>();
        for (String elem : rolesArray) {
            roles.add(roleService.getRoleByName(elem));
        }
        user.setRoles(roles);
        userService.add(user);
        return "redirect:/login";
    }

    @RequestMapping("admin/deleteUser")
    public String deleteUser(@RequestParam long id) {
        userService.deleteUser(id);
        return "redirect:/admin/userList";
    }

    @RequestMapping("admin/updateUser")
    public String updateUser(@RequestParam long id, ModelMap modelMap) {
        User user = userService.getUserById(id);
        modelMap.addAttribute("roleList", roleService.roleList());
        modelMap.addAttribute("user", user);
        return "updateUser";
    }

    @PostMapping("admin/save")
    public String saveUser(@ModelAttribute("user") User user, @RequestParam ArrayList<String> role) {
        Set<Role> roleSet = new HashSet<>();
        for (String roleId : role) {
            roleSet.add(roleService.getById(Long.valueOf(roleId)));
        }
        user.setRoles(roleSet);
        userService.updateUser(user);
        return "redirect:/admin/userList";
    }

    @GetMapping("user")
    public String userPage() {
        return "user";
    }
}
