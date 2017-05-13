package com.epam.HotelReleaze.dao;

import com.epam.HotelReleaze.models.User;

import java.util.List;

/**
 * Created by Antoha12018 on 12.05.2017.
 */
public interface UserService {
    List<User> getAllUsers();
    User findByUsername(String username);
    void save(User user);
}
