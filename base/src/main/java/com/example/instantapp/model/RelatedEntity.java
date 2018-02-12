package com.example.instantapp.model;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class RelatedEntity {

    @Id
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
