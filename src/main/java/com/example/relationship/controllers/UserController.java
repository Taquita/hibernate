package com.example.relationship.controllers;

import com.example.relationship.models.phone.PhoneCreateDTO;
import com.example.relationship.models.user.UserCreateDTO;
import com.example.relationship.models.user.UserReturnDTO;
import com.example.relationship.models.user.UserUpdateDTO;
import com.example.relationship.services.PhoneService;
import com.example.relationship.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "UserController", description = "User endpoints")
@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;
    private final PhoneService phoneService;

    @Autowired
    public UserController(UserService userService, PhoneService phoneService) {
        this.userService = userService;
        this.phoneService = phoneService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Create User")
    public ResponseEntity<UserReturnDTO> createUser(
            @ApiParam(value = "User entity", required = true)
            @RequestBody UserCreateDTO user
    ) {
        return new ResponseEntity<UserReturnDTO>(this.userService.create(user), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ApiOperation(value = "Update User")
    public ResponseEntity<UserReturnDTO> updateUser(
            @ApiParam(value = "User entity", required = true)
            @RequestBody UserUpdateDTO user
    ) {
        UserReturnDTO entity = this.userService.update(user);
        return new ResponseEntity<UserReturnDTO>(entity, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Get User by ID")
    public ResponseEntity<UserReturnDTO> getUser(
            @ApiParam(value = "User ID", required = true)
            @PathVariable Long id
    ) {
        UserReturnDTO entity =  this.userService.getOne(id);
        return new ResponseEntity<UserReturnDTO>(entity, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Remove User by ID")
    public void removeUser(
            @ApiParam(value = "User ID", required = true)
            @PathVariable Long id
    ) {
        this.userService.remove(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Users in Pagination")
    public Page<UserReturnDTO> getPaginate(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "count", defaultValue = "10") int count,
            @RequestParam(value = "direction", defaultValue = "ASC") Sort.Direction direction,
            @RequestParam(value = "property", defaultValue = "id") String property
    ) {
        return this.userService.pagine(page, count, direction, property);
    }

    @RequestMapping(value = "/{id}/phone", method = RequestMethod.POST)
    @ApiOperation(value = "Adding Phone in User")
    public ResponseEntity<UserReturnDTO> addPhone(
            @ApiParam(value = "User ID for Adding", required = true)
            @PathVariable Long id,
            @ApiParam(value = "Phone entity", required = true)
            @RequestBody PhoneCreateDTO phone
    ) {
        UserReturnDTO entity = this.phoneService.addPhoneInUser(id, phone);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/phone/{phoneId}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Remove User Phone By ID")
    public ResponseEntity<UserReturnDTO> removePhone(
            @ApiParam(value = "User ID", required = true)
            @PathVariable Long id,
            @ApiParam(value = "Phone ID", required = true)
            @PathVariable Long phoneId
    ) {
        UserReturnDTO entity = this.phoneService.remove(id, phoneId);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }
}
