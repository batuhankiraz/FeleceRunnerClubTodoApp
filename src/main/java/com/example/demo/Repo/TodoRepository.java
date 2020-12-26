package com.example.demo.Repo;

import com.example.demo.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Integer> {

    List<Todo> findAll();

    List<Todo> findByTodoUserModelUserId(int userId);
}
