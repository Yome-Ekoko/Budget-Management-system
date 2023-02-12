package com.example.decapay.controllers;

import com.example.decapay.pojos.requestDtos.ForgetPasswordRequest;
import com.example.decapay.pojos.requestDtos.ResetPasswordRequest;
import com.example.decapay.pojos.requestDtos.UserUpdateRequest;
import com.example.decapay.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Service
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;
    @PutMapping("/edit")
    public ResponseEntity<String> editUser(@Valid @RequestBody UserUpdateRequest userUpdateRequest){

        return userService.editUser(userUpdateRequest);
    }
    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestBody @Valid ForgetPasswordRequest request){
        return new ResponseEntity<>(userService.forgotPasswordRequest(request), HttpStatus.OK);
    }

    @PostMapping("/reset-password")
    public String resetPassword(@RequestBody @Valid ResetPasswordRequest request){
        return userService.resetPassword(request);
    }
    @GetMapping("/verify-token/{token}")
    public ResponseEntity<?> verifyToken( @PathVariable("token") String token) {
        return new ResponseEntity<>(userService.verifyToken(token),HttpStatus.FOUND);
    }
}
