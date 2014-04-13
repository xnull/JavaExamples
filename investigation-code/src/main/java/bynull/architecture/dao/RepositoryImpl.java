package bynull.architecture.dao;

import bynull.architecture.localapi.dao.EntityLocalApi;
import bynull.architecture.localapi.dao.MutableEntityLocalApi;
import bynull.architecture.localapi.dao.RepositoryLocalApi;
import bynull.architecture.publicapi.dao.Repository;

/**
 * Created by null on 2/13/14.
 */
public class RepositoryImpl implements RepositoryLocalApi, Repository<EntityLocalApi, MutableEntityLocalApi> {

    @Override
    public MutableEntityLocalApi buildEntity() {
        return new EntityImpl();
    }
}
