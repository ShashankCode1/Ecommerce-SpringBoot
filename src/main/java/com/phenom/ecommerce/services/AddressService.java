package com.phenom.ecommerce.services;

import com.phenom.ecommerce.models.Address;
import com.phenom.ecommerce.models.User;
import com.phenom.ecommerce.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    UserService userService;

    public List<Address> getAddresses() {
        return addressRepository.findAll();
    }

    public String addAddressByUserId(Address address, String userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            Address userAddress = new Address();
            userAddress.setDoorNo(address.getDoorNo());
            userAddress.setStreet(address.getStreet());
            userAddress.setCity(address.getCity());
            addressRepository.save(userAddress);
            Address savedAddress = addressRepository.findById(userAddress.getAddressId()).orElse(null);
            if(savedAddress != null) {
                List<Address> addressList = user.getAddressList();
                if (addressList == null) {
                    addressList = new ArrayList<>();
                }
                addressList.add(savedAddress);
                user.setAddressList(addressList);
                userService.updateUserAddressList(userId, user.getAddressList());
                return "Address added successfully";
            } else {
                return "Address Id not found";
            }
        } else {
            return "User Id is not found";
        }
    }

    public String deleteAddressByUserId(String userId, String addressId) {
        Address address = addressRepository.findById(addressId).orElse(null);
        if (address != null) {
            addressRepository.deleteById(addressId);
            userService.deleteAddressByUserId(userId, addressId);
            return "Address deleted";
        } else {
            return "Address Id not found";
        }
    }

}
