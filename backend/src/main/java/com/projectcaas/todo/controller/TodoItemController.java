package com.projectcaas.todo.controller;

import com.projectcaas.todo.model.TodoItem;
import com.projectcaas.todo.repository.TodoItemRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/items")
public class TodoItemController {

    private final TodoItemRepository repository;

    public TodoItemController(TodoItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<TodoItem> getItems() {
        return repository.findAll();
    }

    @PostMapping
    public TodoItem addItem(@RequestBody Map<String, String> body) {
        TodoItem item = new TodoItem();
        item.setId(UUID.randomUUID().toString());
        item.setName(body.get("name"));
        item.setCompleted(false);
        return repository.save(item);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoItem> updateItem(@PathVariable String id,
                                               @RequestBody Map<String, Object> body) {
        return repository.findById(id)
                .map(item -> {
                    if (body.containsKey("name")) {
                        item.setName((String) body.get("name"));
                    }
                    if (body.containsKey("completed")) {
                        item.setCompleted((Boolean) body.get("completed"));
                    }
                    return ResponseEntity.ok(repository.save(item));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
