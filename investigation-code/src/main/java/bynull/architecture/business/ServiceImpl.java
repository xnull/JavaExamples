package bynull.architecture.business;

import bynull.Utils.Utils;
import bynull.architecture.dao.RepositoryImpl;
import bynull.architecture.localapi.dao.EntityLocalApi;
import bynull.architecture.localapi.dao.MutableEntityLocalApi;
import bynull.architecture.localapi.dao.RepositoryLocalApi;

/**
 * Created by null on 2/13/14.
 */
public class ServiceImpl {

    private RepositoryLocalApi repo = new RepositoryImpl();

    public void heyHello(EntityLocalApi entity) {
        MutableEntityLocalApi resultEntity = repo.buildEntity();
        resultEntity.setId(123L);
        resultEntity.setName(entity.getName());

        Utils.print(resultEntity);
    }
}
