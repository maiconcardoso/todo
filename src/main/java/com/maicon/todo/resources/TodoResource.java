package com.maicon.todo.resources;

import java.util.List;

import com.maicon.todo.domain.Todo;
import com.maicon.todo.services.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/all")
public class TodoResource {

    @Autowired
    private TodoService service;
    
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
}
