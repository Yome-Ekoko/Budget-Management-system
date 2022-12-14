package com.example.decapay.controllers.auth;


import com.example.decapay.pojos.requestDtos.PasswordUpdateRequest;
import com.example.decapay.services.PasswordUpdateService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/auth")
public class UpdatePasswordController {
    private final PasswordUpdateService passwordUpdateService;

    @PostMapping("/update-password")
    public ResponseEntity<String> updatePassword(@Valid @RequestBody PasswordUpdateRequest passwordUpdateRequest){
        this.passwordUpdateService.updatePassword(passwordUpdateRequest);
        return new ResponseEntity<>("password updated successfully!", HttpStatus.OK);
    }
}
