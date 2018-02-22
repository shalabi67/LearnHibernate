package com.lean.hibernate.entity;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private Address address = new Address();
    private List<UserHistory> userHistories = new ArrayList<UserHistory>();

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "firstName", nullable = false, length = 45)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "lastName", nullable = false, length = 45)
    public String getLastName() {
        return lastName;
    }

    @Embedded
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    public List<UserHistory> getUserHistories() {
        return userHistories;
    }

    public void setUserHistories(List<UserHistory> userHistories) {
        this.userHistories = userHistories;
    }

    public void addHistory(UserHistory userHistory) {
        userHistory.setUser(this);
        userHistories.add(userHistory);
    }
}
