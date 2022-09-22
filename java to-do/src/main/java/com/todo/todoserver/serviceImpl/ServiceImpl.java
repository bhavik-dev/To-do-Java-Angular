package com.todo.todoserver.serviceImpl;

import com.todo.todoserver.entity.Todo;
import com.todo.todoserver.repositories.TodoRepository;
import com.todo.todoserver.service.Service;

import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

    private TodoRepository todoRepository;

    public ServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public Todo saveTodo(Todo todo) {
        todo.setCreateDate(new Date());
        return todoRepository.save(todo);
    }

    @Override
    public List<Todo> getTodoList() {
        return todoRepository.findAll();
    }

    @Override
    public Todo findById(long id) {
        return todoRepository.findById(id).get();
    }

    @Override
    public void deleteById(long id) {
        todoRepository.deleteById(id);
    }

    @Override
    public Todo updateById(long id, Todo todo) {
        Todo temp = todoRepository.findById(id).get();
        temp.setDesc(todo.getDesc());
        temp.setDueDate(new Date());
        temp.setStatus(todo.isStatus());
        return todoRepository.save(temp);
    }

    @Override
    public List<Todo> fromToList(long from, long to) {
        if(!todoRepository.existsById(from) && !todoRepository.existsById(to))
            return null;
        return todoRepository.findByIdBetween(from, to);
    }
}
