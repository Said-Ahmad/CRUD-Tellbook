package com.example.crudtellbook.controller;

import com.example.crudtellbook.model.UserDto;
import com.example.crudtellbook.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/user")
public class UserController {
    private final UserService userService;

    @PostMapping(path = "/create")

    private ResponseEntity<UserDto> createUser(@RequestBody UserDto dto) {
        return ResponseEntity.ok(userService.createUser(dto));
    }

    @PutMapping(path = "/update")
    private ResponseEntity<UserDto> updateUser(@RequestBody UserDto dto) {
        return ResponseEntity.ok(userService.updateUser(dto));
    }

    @DeleteMapping(path = "/delete")
    private ResponseEntity<Boolean> deleteUser(@RequestParam(name = "id") Integer id) {

        return ResponseEntity.ok(userService.deleteUser(id));
    }

    @DeleteMapping(path = "/deleteByPhoneNumber")
    private ResponseEntity<Boolean> deleteUser(@RequestParam(name = "phoneNumber") String phoneNumber) {

        return ResponseEntity.ok(userService.deleteUserByPhoneNumber(phoneNumber));
    }

    @GetMapping(path = "/all")
    private ResponseEntity<List<UserDto>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping(path = "/Id")
    private ResponseEntity<UserDto> getUserById(@RequestParam(name = "Id") Integer id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping(path = "/phoneNumber")
    private ResponseEntity<UserDto> getUserByPhoneNumber(@RequestParam(name = "phoneNumber") String phoneNumber) {
        return ResponseEntity.ok(userService.getUserByPhoneNumber(phoneNumber));
    }


}
