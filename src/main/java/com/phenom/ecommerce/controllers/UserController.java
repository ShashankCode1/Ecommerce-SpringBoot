package com.phenom.ecommerce.controllers;

import com.phenom.ecommerce.models.Address;
import com.phenom.ecommerce.models.User;
import com.phenom.ecommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable String userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/addressList/{userId}")
    public List<Address> getAddressListByUserId(@PathVariable String userId) {
        return userService.getAddressListByUserId(userId);
    }

    @PostMapping
    public String addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PatchMapping
    public String updateUserAddressList(String userId, List<Address> addressList) {
        return userService.updateUserAddressList(userId, addressList);
    }

    @GetMapping("/count")
    public int getUsersCount() {
        return userService.getUsersCount();
    }

    @DeleteMapping("/{userId}/{addressId}")
    public String deleteAddressByUserId(@PathVariable String userId, @PathVariable String addressId) {
        return userService.deleteAddressByUserId(userId, addressId);
    }

}
