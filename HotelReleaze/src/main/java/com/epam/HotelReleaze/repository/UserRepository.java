package com.epam.HotelReleaze.repository;

import com.epam.HotelReleaze.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Antoha12018 on 10.05.2017.
 */
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
