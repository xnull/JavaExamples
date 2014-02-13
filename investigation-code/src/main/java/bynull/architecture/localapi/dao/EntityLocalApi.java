package bynull.architecture.localapi.dao;

import bynull.architecture.publicapi.dao.Entity;

/**
 * Created by null on 2/13/14.
 */
public interface EntityLocalApi extends Entity {
    Long getId();
    String getName();
}
