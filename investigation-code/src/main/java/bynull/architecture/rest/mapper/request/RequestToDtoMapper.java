package bynull.architecture.rest.mapper.request;

import bynull.architecture.publicapi.mapping.Mapper;
import bynull.architecture.rest.DtoImpl;
import bynull.architecture.rest.Request;

/**
 * Created by null on 2/13/14.
 */
public class RequestToDtoMapper implements Mapper<Request, DtoImpl> {

    @Override
    public DtoImpl map(Request request) {
        DtoImpl dto = new DtoImpl();
        dto.setName(request.getName());
        return dto;
    }
}
