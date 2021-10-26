package com.maicon.todo.repositories;

import java.util.List;

import com.maicon.todo.domain.Todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer>{

    @Query("SELECT obj FROM Todo obj WHERE obj.finished = false ORDER BY obj.finishedDate")
    List<Todo> findAllOpen();

    @Query("SELECT obj FROM Todo obj WHERE obj.finished = true ORDER BY obj.finishedDate")
    List<Todo> findAllClosed();
    
}
