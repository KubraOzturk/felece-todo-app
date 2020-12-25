package com.service;

import com.dto.TodoDto;
import com.mapper.TodoMapper;
import com.model.TodoItem;
import com.model.User;
import com.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Validated
@Service
@RequiredArgsConstructor
public class TodoService implements TodoServiceIn {
    @Autowired
    private com.repo.TodoRepo todoRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private TodoMapper todoMapper;

    @Override
    public TodoDto addToDo(TodoDto recipeDto) {
        TodoItem toDo = todoMapper.toToDo(recipeDto);
        try {
            toDo.setUser(userRepo.getOne(recipeDto.getUserDto().getId()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return todoMapper.toToDoDto(todoRepo.save(toDo));

    }

    @Override
    public TodoDto updateToDo(TodoDto toDoDto){
        TodoItem todoDb = todoRepo.findById(toDoDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("ToDo : " + toDoDto.getId() + "does not exist !"));
        todoDb.setTitle(toDoDto.getTitle());
        todoDb.setDescription(toDoDto.getDescription());
        todoDb.setDate(toDoDto.getDate());
        todoDb.setStatus(todoDb.getStatus());
        return todoMapper.toToDoDto(todoRepo.save(todoDb));
    }


    @Override
    public List<TodoDto> getList() {
        return todoMapper.toToDoDtoList(todoRepo.findAll());
    }

    @Override
    public List<TodoDto> getListByUserId(long userId) {
        return todoMapper.toToDoDtoList(todoRepo.findAllByUserId(userId));
    }

    @Override
    public List<TodoDto> getListByDate(Long id, Date startDate, Date endDate) {
        return todoMapper.toToDoDtoList(todoRepo.findByUserIdAndDateBetween(id, startDate,endDate));
    }

    @Override
    public TodoDto getToDo(long id) {
        TodoDto recipeDto = todoMapper.toToDoDto(todoRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("ToDo : " + id + "does not exist !")));
        return recipeDto;
    }

    @Override
    public void deleteToDo(long id) {
        todoRepo
                .delete(todoRepo
                        .findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("ToDo : " + id + "does not exist !")));
    }

    @Override
    public List<TodoDto> getListByContainingTitle(String title) {
        //return todoMapper.toTodoDtoList(todoRepo.findByTitleContaining(title));
        return null;
    }

    public boolean toDoSecurity(Long id, Principal principal){
        Optional<TodoItem> todo = todoRepo.findById(id);
        String todoUsername = todo.get().getUser().getUsername();
        System.out.println(todoUsername);
        System.out.println(principal.getName());
        if (todoUsername.equals(principal.getName())){
            return true;
        }
        return false;
    }

    public boolean userSecurity(Long id, Principal principal){
        Optional<User> user = userRepo.findById(id);
        String Username = user.get().getUsername();
        System.out.println(Username);
        System.out.println(principal.getName());
        if (Username.equals(principal.getName())){
            return true;
        }
        return false;
    }

}
