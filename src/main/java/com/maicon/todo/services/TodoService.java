package com.maicon.todo.services;

import java.util.Optional;

import com.maicon.todo.domain.Todo;
import com.maicon.todo.repositories.TodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public Todo findById(Integer id) {
        Optional<Todo> todoById = repository.findById(id);
        return todoById.orElse(null);
    }
}
