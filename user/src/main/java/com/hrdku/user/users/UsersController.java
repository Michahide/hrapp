package com.hrdku.user.users;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrdku.user.dto.ResponseData;
import com.hrdku.user.dto.SearchData;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")

public class UsersController {
    @Autowired
    private UsersService usersService;

    @GetMapping
    public ResponseEntity<ResponseData<Users>> fetchAll() {
        ResponseData<Users> responseData = new ResponseData<>();
        try {
            responseData.setResult(true);
            List<Users> value = (List<Users>) usersService.findAll();
            responseData.setData(value);

            return ResponseEntity.ok(responseData);
        } catch (Exception ex) {
            responseData.setResult(false);
            responseData.getMessage().add(ex.getMessage());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseData<Users>> findOne(@PathVariable("id") int id) {
        ResponseData<Users> responseData = new ResponseData<>();
        try {
            responseData.setResult(true);
            List<Users> value = new ArrayList<>();
            value.add(usersService.findOne(id));
            responseData.setData(value);

            return ResponseEntity.ok(responseData);
        } catch (Exception ex) {
            responseData.setResult(false);
            responseData.getMessage().add(ex.getMessage());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseData<Users>> Create(@Valid @RequestBody Users users, Errors errors) {
        ResponseData<Users> responseData = new ResponseData<>();
        if (errors.hasErrors()) {
            responseData.setResult(false);
            errors.getAllErrors().forEach(error -> responseData.getMessage().add(error.getDefaultMessage()));
            responseData.setData(null);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        responseData.setResult(true);
        List<Users> value = new ArrayList<>();
        value.add(usersService.create(users));
        responseData.setData(value);
        return ResponseEntity.ok(responseData);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseData<Users>> updateStudents(@Valid @RequestBody Users users, Errors errors){
        ResponseData<Users> responseData = new ResponseData<>();
        if (errors.hasErrors()) {
            errors.getAllErrors().forEach(error -> responseData.getMessage().add(error.getDefaultMessage()));
            responseData.setResult(false);
            responseData.setData(null);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        try {
            responseData.setResult(true);
            List<Users> value = new ArrayList<>();
            value.add(usersService.update(users));
            responseData.setData(value);

            return ResponseEntity.ok(responseData);
        } catch (Exception ex) {
            responseData.getMessage().add("ID is Required");
            responseData.setResult(false);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseData<Void>> removeOne(@PathVariable("id") int id) {
        ResponseData<Void> responseData = new ResponseData<>();
        try {
            usersService.removeOne(id);
            responseData.setResult(true);
            responseData.getMessage().add("Successfully Removed");

            return ResponseEntity.ok(responseData);
        } catch (Exception ex) {
            responseData.setResult(false);
            responseData.getMessage().add(ex.getMessage());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<ResponseData<Users>> getStudentByName(@RequestBody SearchData searchData){
        ResponseData<Users> responseData = new ResponseData<>();
        try{
            List<Users> values = (List<Users>) usersService.findByName(searchData.getSearchKey());
            responseData.setResult(true);
            responseData.setMessage(null);
            responseData.setData(values);
            return ResponseEntity.ok(responseData);
        } catch (Exception e){
            List <String> message = new ArrayList<>();
            message.add(e.getMessage());
            responseData.setMessage(message);
            responseData.setData(null);
            responseData.setResult(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

    }
}
