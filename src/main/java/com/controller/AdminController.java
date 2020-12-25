package com.controller;


import com.api.TodoListResponse;
import com.api.UserListResponse;
import com.api.UserRequest;
import com.api.UserResponse;
import com.security.SignupRequest;
import com.service.AuthService;
import com.service.TodoServiceIn;
import com.service.UserServiceIn;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/admin")
public class AdminController {
    @Autowired
    private  final UserServiceIn userServiceIn;
    @Autowired
    private final TodoServiceIn todoServiceIn;
    @Autowired
    AuthService authService;

    @CrossOrigin
    @GetMapping("/todolist")

    public ResponseEntity<TodoListResponse> getToDoList(){
        try{
            TodoListResponse res = new TodoListResponse();
            //res.setTodoList(toDoService.getList());
            return ResponseEntity.ok(res);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
    @CrossOrigin
    @GetMapping("/user/{userId}")

    public ResponseEntity<TodoListResponse> getToDoListByUserId(@PathVariable(name = "userId") long userId) {
        try {
            TodoListResponse res = new TodoListResponse();
            //res.setToDoList(toDoService.getListByUserId(userId));
            return ResponseEntity.ok(res);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
    @CrossOrigin
    @GetMapping("/todos/{startDate}/{endDate}")

    public ResponseEntity<TodoListResponse> getToDoListByDate(@PathVariable(name = "startDate")  @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                                              @PathVariable(name = "endDate")   @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        System.out.println(startDate + " "+ endDate);
        try {
            TodoListResponse res = new TodoListResponse();
            //res.setToDoList(userService.getListByDateBetween(startDate,endDate));
            return ResponseEntity.ok(res);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable(name = "id") long id) {
        try {
            UserResponse res = new UserResponse();
            //res.setUserDto(userService.getUser(id));
            return ResponseEntity.ok(res);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @CrossOrigin
    @GetMapping("/list")

    public ResponseEntity<UserListResponse> getUsers() {
        try {
            UserListResponse res = new UserListResponse();
            //res.setUserDtoList(userService.getUsers());
            return ResponseEntity.ok(res);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @CrossOrigin
    @PostMapping

    public ResponseEntity<?> addUser(@RequestBody SignupRequest signupRequest) {
        try {
            return ResponseEntity.ok(authService.signUp(signupRequest));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin
    @PutMapping
    public ResponseEntity<UserResponse> updateUser(@RequestBody UserRequest req)  {
        try {
            UserResponse res = new UserResponse();
           // res.setUserDto(userService.updateUser(req.getUserDto()));
            return ResponseEntity.ok(res);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @CrossOrigin
    @DeleteMapping("/{id}")

    public ResponseEntity deleteUser(@PathVariable(name = "id") long id){
        try{
            userServiceIn.deleteUser(id);
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}

