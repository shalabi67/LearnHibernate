package com.lean.hibernate.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user_history", schema = "hello-world")
public class UserHistory {
    private int id;
    private Timestamp entryTime;
    private String entry;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "entry_time", nullable = false)
    public Timestamp getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Timestamp entryTime) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserHistory that = (UserHistory) o;

        if (id != that.id) return false;
        if (entryTime != null ? !entryTime.equals(that.entryTime) : that.entryTime != null) return false;
        if (entry != null ? !entry.equals(that.entry) : that.entry != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (entryTime != null ? entryTime.hashCode() : 0);
        result = 31 * result + (entry != null ? entry.hashCode() : 0);
        return result;
    }
}
