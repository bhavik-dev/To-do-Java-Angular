package com.todo.todoserver.service;

import com.todo.todoserver.entity.Todo;

import java.util.List;

@org.springframework.stereotype.Service
public interface Service {
    Todo saveTodo(Todo todo);
    List<Todo> getTodoList();
    Todo findById(long id);
    void deleteById(long id);
    Todo updateById(long id, Todo todo);
    List<Todo> fromToList(long from, long to);
}
