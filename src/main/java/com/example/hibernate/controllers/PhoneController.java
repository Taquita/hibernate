package com.example.hibernate.controllers;

import com.example.hibernate.models.phone.PhoneCompleteDTO;
import com.example.hibernate.services.PhoneService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "PhoneController", description = "Phone endpoints")
@RestController
@RequestMapping(value = "/phone")
public class PhoneController {

    private final PhoneService phoneService;

    @Autowired
    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ApiOperation(value = "Update Phone")
    public ResponseEntity<PhoneCompleteDTO> updatePhone(
            @ApiParam(value = "Phone entity", required = true)
            @RequestBody PhoneCompleteDTO phone
    ) {
        PhoneCompleteDTO entity = this.phoneService.update(phone);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

}
