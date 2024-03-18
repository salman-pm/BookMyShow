package dev.salman.BookMyShow.service;

import dev.salman.BookMyShow.exception.InvalidUserEmailException;
import dev.salman.BookMyShow.exception.InvalidUserPasswordException;
import dev.salman.BookMyShow.model.User;
import dev.salman.BookMyShow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User login(String email, String password){
        User savedUser = userRepository.findUserByEmail(email);
        if(savedUser == null){
            throw new InvalidUserEmailException("Invalid email - No user found for this email");
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(encoder.matches(password, savedUser.getPassword())){
            return savedUser;
        }else{
            throw new InvalidUserPasswordException("Invalid Password");
        }
    }

    public User signUpUser(String name, String email, String password){
        User savedUser = userRepository.findUserByEmail(email);
        if(savedUser != null){
            throw new InvalidUserEmailException("Email already exists");
        }
        User newUser = new User();
        newUser.setName(name);
        newUser.setEmail(email);
        //encode and save the password
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        newUser.setPassword(encoder.encode(password));
        newUser.setTickets(new ArrayList<>());
        return userRepository.save(newUser);
    }
}
