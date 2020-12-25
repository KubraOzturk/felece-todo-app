package com.controller;
import com.model.TodoItem;
import com.repo.TodoRepo;
import com.repo.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping(value = "/todo")
@RequiredArgsConstructor
public class TodoController {
    @Autowired
    private TodoRepo todoRepo;
    @CrossOrigin
    @GetMapping("/todo/{id}")

    public List<TodoItem> findAll(){
        return todoRepo.findAll();
    }
    @PostMapping
    public TodoItem save(@Valid @NotNull @RequestBody TodoItem todoItem){
       return todoRepo.save(todoItem);
    }



}
