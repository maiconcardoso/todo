package com.maicon.todo.services;

import java.util.List;
import java.util.Optional;

import com.maicon.todo.domain.Todo;
import com.maicon.todo.repositories.TodoRepository;
import com.maicon.todo.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public List<Todo> findAll() {
        return repository.findAll();
    }

    public Todo findById(Integer id) {
        Optional<Todo> todoById = repository.findById(id);
        return todoById.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Todo> findAllOpen() {
        List<Todo> listOpen = repository.findAllOpen();
        return listOpen;
    }

    public List<Todo> findAllClosed() {
        List<Todo> listClosed = repository.findAllClosed();
        return listClosed;
    }

    public Todo save(Todo todo) {
        return repository.save(todo);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Todo update(Integer id, Todo todo) {
        Todo todoById = repository.findById(id).get();
        Todo todoForUpdated = todoById;
        todoForUpdated.setTitle(todo.getTitle());
        todoForUpdated.setDescription(todo.getDescription());
        todoForUpdated.setFinished(todo.getFinished());
        todoForUpdated.setFinishedDate(todo.getFinishedDate());
        return repository.save(todoForUpdated);
    }
}
