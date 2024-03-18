package dev.salman.BookMyShow.controller;

import dev.salman.BookMyShow.dto.*;
import dev.salman.BookMyShow.exception.InvalidUserNameException;
import dev.salman.BookMyShow.exception.InvalidUserPasswordException;
import dev.salman.BookMyShow.model.User;
import dev.salman.BookMyShow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("login")
    public ResponseEntity<UserLoginResponseDto> login(@RequestBody UserLoginRequestDto userLoginRequestDto){
        UserLoginResponseDto userLoginResponseDto = new UserLoginResponseDto();
        try{
            String email = userLoginRequestDto.getEmail();
            String password = userLoginRequestDto.getPassword();
            if(password.length() < 8){
                throw new InvalidUserPasswordException("Password length should be more than 8 characters");
            }
            User user = userService.login(email, password);
            userLoginResponseDto.setId(user.getId());
            userLoginResponseDto.setTickets(user.getTickets());
            userLoginResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
            return ResponseEntity.ok(userLoginResponseDto);
        }
        catch (Exception e){
            userLoginResponseDto = new UserLoginResponseDto();
            userLoginResponseDto.setResponseStatus(ResponseStatus.FAILURE);
            return ResponseEntity.ok(userLoginResponseDto);
        }
    }

    @PostMapping("/signUp")
    public ResponseEntity<UserSignResponseDto> singUp(@RequestBody UserSignUpRequestDto userSignUpRequestDto){
        UserSignResponseDto userSignResponseDto = new UserSignResponseDto();
        String name = userSignUpRequestDto.getName();
        String email = userSignUpRequestDto.getEmail();
        String password = userSignUpRequestDto.getPassword();
        try{
            if(name == null || name.isBlank() || name.length() <= 3){
                throw new InvalidUserNameException("Name cannot be null, empty, blank & Name length should be more than 3 chars");
            }
            if(password.length() < 8){
                throw new InvalidUserPasswordException("Password length should be more than 8 characters");
            }
            User user = userService.signUpUser(name, email, password);
            userSignResponseDto.setId(user.getId());
            userSignResponseDto.setTickets(user.getTickets());
            userSignResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
            return ResponseEntity.ok(userSignResponseDto);
        }
        catch (Exception e){
            userSignResponseDto = new UserSignResponseDto();
            userSignResponseDto.setResponseStatus(ResponseStatus.FAILURE);
            return ResponseEntity.ok(userSignResponseDto);
        }
    }
}
