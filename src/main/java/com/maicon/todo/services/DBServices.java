package com.maicon.todo.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import com.maicon.todo.domain.Todo;
import com.maicon.todo.repositories.TodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBServices {

    @Autowired
	TodoRepository repository;

    public void dataBaseInstance() {
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		Todo t1 = new Todo(null, "Estudar", "Estudar Spring Book", LocalDateTime.parse("25/03/2022 10:40", formater), false);
		repository.saveAll(Arrays.asList(t1));
    }
    
}
