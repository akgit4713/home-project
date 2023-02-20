package com.homeproject.homeproject.service;

import com.homeproject.homeproject.dao.UserRepository;
import com.homeproject.homeproject.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRepository userRepository;
    public Optional<User> findUserbyId(String id){
        try{
            return userRepository.findById(id);
        }
        catch (Exception e){
            LOG.info("Some error occurred while getting User from DB {}", e.getMessage());
            return Optional.empty();
        }
    }

    public void saveUser(User user) {
        try{
            userRepository.save(user);
        }
        catch (Exception e){
            LOG.info("Some error occurred while saving the user to DB {}", e.getMessage());
        }
    }

    public List<User> getAllUsers() {
        try{
            return userRepository.findAll();
        }
        catch (Exception e){
            LOG.info("Some error occurred while fetching all users from DB {}", e.getMessage());
            return Collections.emptyList();
        }
    }
}
