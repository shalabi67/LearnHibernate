package com.lean.hibernate.entity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "user_history", schema = "hello-world")
public class UserHistory {
    private int id;
    private Date entryTime;
    private String entry;
    private User user = new User();

    public UserHistory() {

    }
    public UserHistory(Date entryTime, String entry) {
        this.entryTime = entryTime;
        this.entry = entry;

    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "entry_time", nullable = false)
    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    @Basic
    @Column(name = "entry", nullable = false, length = 45)
    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
