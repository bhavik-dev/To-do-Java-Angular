package com.todo.todoserver.controller;

import com.todo.todoserver.entity.Todo;
import com.todo.todoserver.serviceImpl.ServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    private ServiceImpl serviceImpl;

    public TodoController(ServiceImpl serviceImpl) {
        super();
        this.serviceImpl = serviceImpl;
    }

    @GetMapping("{id}")
    public Todo getTodo(@PathVariable("id") long id){
        return serviceImpl.findById(id);
    }

    @GetMapping("/list")
    public List<Todo> getTodoList(){
        return serviceImpl.getTodoList();
    }

    @GetMapping("/list-from-to")
    public List<Todo> getTodoListFromTo(@RequestParam(name = "from") long from, @RequestParam(name = "to") long to){
        return serviceImpl.fromToList(from, to);

    }


    @PostMapping()
    public ResponseEntity<Todo> saveTodo(@RequestBody Todo todo){
        return new ResponseEntity<Todo>(serviceImpl.saveTodo(todo), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public String deleteById(@PathVariable("id") long id){
        serviceImpl.deleteById(id);
        return "Deleted todo of Id: "+id;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateById(@PathVariable("id") long id, @RequestBody Todo todo){
        return new ResponseEntity<Todo>( serviceImpl.updateById(id, todo), HttpStatus.OK);
    }
    @GetMapping("/api/v1/dor-iss/application")
    public ResponseEntity<?> demo (@RequestBody Object o)
    {
        return new ResponseEntity<>(o , HttpStatus.OK);
    }

}
