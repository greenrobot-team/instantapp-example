package com.example.instantapp.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.NotNull;

@Entity
public class ExampleEntity {

    @Id
    private long id;

    private long relatedId;

    @ToOne(joinProperty = "relatedId")
    private RelatedEntity related;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 3071140)
    private transient ExampleEntityDao myDao;

    @Generated(hash = 468174174)
    public ExampleEntity(long id, long relatedId) {
        this.id = id;
        this.relatedId = relatedId;
    }

    @Generated(hash = 432642163)
    public ExampleEntity() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRelatedId() {
        return this.relatedId;
    }

    public void setRelatedId(long relatedId) {
        this.relatedId = relatedId;
    }

    @Generated(hash = 1009720331)
    private transient Long related__resolvedKey;

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1184634899)
    public RelatedEntity getRelated() {
        long __key = this.relatedId;
        if (related__resolvedKey == null || !related__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            RelatedEntityDao targetDao = daoSession.getRelatedEntityDao();
            RelatedEntity relatedNew = targetDao.load(__key);
            synchronized (this) {
                related = relatedNew;
                related__resolvedKey = __key;
            }
        }
        return related;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 654134194)
    public void setRelated(@NotNull RelatedEntity related) {
        if (related == null) {
            throw new DaoException(
                    "To-one property 'relatedId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.related = related;
            relatedId = related.getId();
            related__resolvedKey = relatedId;
        }
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 551808277)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getExampleEntityDao() : null;
    }
    
}
