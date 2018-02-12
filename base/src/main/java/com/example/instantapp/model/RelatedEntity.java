package com.example.instantapp.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class RelatedEntity {

    @Id
    private long id;

    @Generated(hash = 1502692852)
    public RelatedEntity(long id) {
        this.id = id;
    }

    @Generated(hash = 1761928194)
    public RelatedEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
