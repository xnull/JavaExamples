package bynull.architecture.dao;

import bynull.architecture.localapi.dao.EntityLocalApi;
import bynull.architecture.localapi.dao.MutableEntityLocalApi;

/**
 * Created by null on 2/13/14.
 */
public class EntityImpl implements EntityLocalApi, MutableEntityLocalApi {

    private Long id;
    private String name;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "EntityImpl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public EntityLocalApi getImmutableEntity() {
        return this;
    }
}
