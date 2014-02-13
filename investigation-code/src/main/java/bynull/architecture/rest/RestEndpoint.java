package bynull.architecture.rest;

import bynull.architecture.business.ServiceImpl;
import bynull.architecture.localapi.dao.EntityLocalApi;
import bynull.architecture.publicapi.mapping.Mapper;
import bynull.architecture.rest.mapper.dao.DtoDaoMapper;
import bynull.architecture.rest.mapper.request.RequestToDtoMapper;

/**
 * Created by null on 2/13/14.
 */
public class RestEndpoint {

    public void execute(Request request){
        ServiceImpl service = new ServiceImpl();

        Mapper<Request, DtoImpl> requestMapper = new RequestToDtoMapper();
        DtoImpl dto = requestMapper.map(request);

        DtoDaoMapper mapper = new DtoDaoMapper();
        EntityLocalApi dao = mapper.map(dto);

        service.heyHello(dao);
    }
}
