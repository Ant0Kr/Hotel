package com.epam.HotelReleaze.dao;

import com.epam.HotelReleaze.models.User;
import com.epam.HotelReleaze.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Antoha12018 on 12.05.2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
   // @Transactional
    public List<User> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return userList;
    }

    @Override
   // @Transactional
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
  //  @Transactional
    public void save(User user) {
        userRepository.save(user);
    }
}
