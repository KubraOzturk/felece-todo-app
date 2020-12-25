package com.repo;
import com.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TodoRepo extends JpaRepository<TodoItem,Long> {
List<TodoItem> findByTitleContaining(String title);
List<TodoItem> findAllByUserId(Long id);
    List<TodoItem> findByDateBetween(Date startDate, Date endDate);
    List<TodoItem> findByUserIdAndDateBetween(Long id, Date startDate, Date endDate);
    Optional<TodoItem> findById(Long id);

}
