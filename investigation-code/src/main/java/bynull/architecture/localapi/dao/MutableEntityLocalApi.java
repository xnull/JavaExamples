package bynull.architecture.localapi.dao;

import bynull.architecture.publicapi.dao.MutableEntity;

/**
 * Created by null on 2/13/14.
 */
public interface MutableEntityLocalApi extends MutableEntity<EntityLocalApi> {
    void setId(Long id);
    void setName(String name);
}
