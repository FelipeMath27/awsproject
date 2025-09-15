package com.cloudpragma.awsproject.infrastructure.input.rest;

import com.cloudpragma.awsproject.application.dto.UserDTORequest;
import com.cloudpragma.awsproject.application.dto.UserDTOResponse;
import com.cloudpragma.awsproject.application.handler.IUserHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
@Slf4j
public class UserRestController {

    private IUserHandler iUserHandler;

    @PostMapping("/create-user")
    public ResponseEntity<Void> createUser(@RequestBody @Valid UserDTORequest userDTORequest){
        iUserHandler.saveDTOUser(userDTORequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/get-user/{idUser}")
    public ResponseEntity<UserDTOResponse> getUser(@PathVariable Long idUser){
        return ResponseEntity.ok(iUserHandler.getUserById(idUser));
    }

}
