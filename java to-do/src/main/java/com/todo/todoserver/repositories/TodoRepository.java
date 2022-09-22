package com.todo.todoserver.repositories;

import com.todo.todoserver.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository <Todo, Long > {
    List<Todo> findByIdBetween(long from, long to);

}
