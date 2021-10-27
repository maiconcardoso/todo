package com.maicon.todo.resources;

import java.net.URI;
import java.util.List;

import com.maicon.todo.domain.Todo;
import com.maicon.todo.services.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/all")
public class TodoResource {

    @Autowired
    private TodoService service;

    @GetMapping
    public ResponseEntity<List<Todo>> findAll() {
        List<Todo> todoList = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(todoList);
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Todo> findById(@PathVariable Integer id) {
        Todo todoById = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(todoById);
    }

    @GetMapping(value = "/open")
    public ResponseEntity<List<Todo>> listOpen() {
        List<Todo> listAllOpen = service.findAllOpen();
        return ResponseEntity.status(HttpStatus.OK).body(listAllOpen);
    }

    @GetMapping(value = "closed")
    public ResponseEntity<List<Todo>> listClosed() {
        List<Todo> listAllClosed = service.findAllClosed();
        return ResponseEntity.status(HttpStatus.OK).body(listAllClosed);
    }

    @PostMapping
    public ResponseEntity<Todo> save(@RequestBody Todo todo) {
        todo = service.save(todo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(todo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
