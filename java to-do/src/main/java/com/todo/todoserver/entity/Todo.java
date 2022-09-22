package com.todo.todoserver.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "todo_desc")
    private String desc;

    @Column(name = "todo_status")
    private boolean status;

    @Column(name = "create_Date")
    @Temporal(TemporalType.DATE)
    private Date createDate;


    @Column(name = "due_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dueDate;

    public Todo() {}

    public Todo(long id, String desc, boolean status, Date createDate, Date dueDate) {
        this.id = id;
        this.desc = desc;
        this.status = status;
        this.createDate = createDate;
        this.dueDate = dueDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}