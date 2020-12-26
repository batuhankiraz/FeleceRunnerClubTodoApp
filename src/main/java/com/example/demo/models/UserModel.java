package com.example.demo.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String roles;
    private String password;
    private String username;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="todoUserModel")
    private Set<Todo> todoSet = new HashSet<>();

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /*public List<String> getRoleList(){
        if (this.roles.length() > 0 ){
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }*/

    public Set<Todo> getTodoSet() {
        return todoSet;
    }

    public void setTodoSet(Set<Todo> todoSet) {
        this.todoSet = todoSet;
    }
}
