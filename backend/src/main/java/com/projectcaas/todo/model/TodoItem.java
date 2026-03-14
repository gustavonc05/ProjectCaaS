package com.projectcaas.todo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "todo_items")
public class TodoItem {

    @Id
    @Column(length = 36)
    private String id;

    @Column(length = 255)
    private String name;

    private boolean completed;

    public TodoItem() {
    }

    public TodoItem(String id, String name, boolean completed) {
        this.id = id;
        this.name = name;
        this.completed = completed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
