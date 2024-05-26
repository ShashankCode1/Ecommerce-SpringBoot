package com.phenom.ecommerce.services;

import com.phenom.ecommerce.models.Address;
import com.phenom.ecommerce.models.User;
import com.phenom.ecommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// UserService class
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    // Get all users
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    // Get user by userId
    public User getUserById(String userId) {
        return userRepository.findById(userId).orElse(null);
    }

    // Get address list by userId
    public List<Address> getAddressListByUserId(String userId) {
        User user = getUserById(userId);
        if (user != null) {
            return user.getAddressList();
        }
        return null;
    }

    // Add user
    // Setting addressList as empty list because based on react code we are not sending addressList
    public String addUser(User user) {
        User newUser = new User();
        newUser.setUserName(user.getUserName());
        newUser.setEmail(user.getEmail());
        newUser.setPhoneNo(user.getPhoneNo());
        newUser.setAddressList(new ArrayList<>());
        userRepository.save(newUser);
        return "User added successfully";
    }

    // Update user address list
    // Setting addressList to user object and saving it => based on react code
    public String updateUserAddressList(String userId, List<Address> addressList) {
        User user = getUserById(userId);
        if (user != null) {
            user.setAddressList(addressList);
            userRepository.save(user);
            return "Address updated";
        } else {
            return "User Id not found";
        }
    }

    // Delete specific address from address list by userId and addressId
    public String deleteAddressByUserId(String userId, String addressId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            List<Address> addressList = user.getAddressList();
            for (Address eachAddress : addressList) {
                if (eachAddress.getAddressId().equals(addressId)) {
                    addressList.remove(eachAddress);
                    updateUserAddressList(userId, addressList);
                    return "Address deleted";
                }
            }
            return "Address Id not found";
        } else {
            return "User id not found";
        }
    }

    // Get users count
    public int getUsersCount() {
        return userRepository.findUsersCount();
    }
}
