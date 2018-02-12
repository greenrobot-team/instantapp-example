package com.example.instantapp.model;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToOne;

@Entity
public class ExampleEntity {

    @Id
    private long id;

    private ToOne<RelatedEntity> related;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ToOne<RelatedEntity> getRelated() {
        return related;
    }
}
