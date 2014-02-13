package bynull.architecture.rest.mapper.dao;

import bynull.architecture.dao.RepositoryImpl;
import bynull.architecture.localapi.dao.EntityLocalApi;
import bynull.architecture.localapi.dao.MutableEntityLocalApi;
import bynull.architecture.localapi.dao.RepositoryLocalApi;
import bynull.architecture.publicapi.mapping.Mapper;
import bynull.architecture.rest.DtoImpl;

/**
 * Created by null on 2/13/14.
 */
public class DtoDaoMapper implements Mapper<DtoImpl, EntityLocalApi> {

    private RepositoryLocalApi repository = new RepositoryImpl();

    @Override
    public EntityLocalApi map(DtoImpl dto) {
        MutableEntityLocalApi result = repository.buildEntity();
        result.setName(dto.getName());
        return result.getImmutableEntity();
    }
}
