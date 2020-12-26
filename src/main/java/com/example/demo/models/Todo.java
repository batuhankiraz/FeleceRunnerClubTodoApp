package com.example.demo.models;


import javax.persistence.*;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private String date;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="userID" , nullable = false)
    private UserModel todoUserModel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public UserModel getTodoUserModel() {
        return todoUserModel;
    }

    public void setTodoUserModel(UserModel todoUserModel) {
        this.todoUserModel = todoUserModel;
    }
}
