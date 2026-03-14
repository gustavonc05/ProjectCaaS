package com.projectcaas.todo.repository;

import com.projectcaas.todo.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoItemRepository extends JpaRepository<TodoItem, String> {
}
