package com.epam.HotelReleaze.dao;

import com.epam.HotelReleaze.models.User;

import java.util.Collection;

/**
 * Created by Antoha12018 on 13.05.2017.
 */
public interface UserDao {
    public void addUser(User user) throws Exception;
    public void updateUser(User user) throws Exception;
    public User getUserById(int id) throws Exception;
    public Collection<User> getAllUsers() throws Exception;
    public void deleteUser(User user) throws Exception;
    public User getUser(String user);
}
