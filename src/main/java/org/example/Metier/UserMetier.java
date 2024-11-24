package org.example.Metier;

import org.example.Dao.UserDao;
import org.example.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.Optional;
import org.example.Config.SecurityConfig;
@Service

public class UserMetier {


    @Autowired
    private UserDao userDao;

    @Autowired
    private SecurityConfig bCryptPasswordEncoder;


    //Register User
    public User registerUser(User user) {
        user.setPassword(bCryptPasswordEncoder.passwordEncoder().encode(user.getPassword()));


        return userDao.save(user);
    }
    // Find user by username
    public Optional<User> findByUsername(String username) {
        return userDao.findByUsername(username);
    }


}