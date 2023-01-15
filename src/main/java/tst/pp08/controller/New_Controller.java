package tst.pp08.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import tst.pp08.model.Role;
import tst.pp08.model.User;
import tst.pp08.service.RoleService;
import tst.pp08.service.UserService;

import java.io.IOException;
import java.util.List;


@RestController
public class New_Controller {


    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;


    @PostMapping("/admin/add")
    public String addUser(@RequestBody User user) throws InterruptedException, IOException {

        userService.add(user);

        return "redirect:/admin";

    }

    @PostMapping("/admin/alcoves")
    public List<Role> sendAllRoles() {

        return roleService.getAllRoles();
    }


    @PostMapping("/admin/getuser")
    public List<User> getUser() {

        return userService.getUser();
    }

    @GetMapping("/admin/getrolebyid/{id}")
    public User getRoleById(@PathVariable int id) {
        return userService.getById(id);

    }

    @PostMapping("/admin/update")
    public void addUpdate(@RequestBody User user) {
       userService.update(user);




    }


    @PostMapping("/admin/del")
    public void addDel(@RequestBody User user) {
        userService.delete(user.getId());

    }


    @PostMapping("/admin/userss")
    public User getUserss(Authentication authentication) {
        String name = authentication.getName();
        User user = userService.findByUsername(name);
        return user;
    }





}
