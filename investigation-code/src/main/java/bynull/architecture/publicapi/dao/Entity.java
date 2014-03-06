package bynull.architecture.publicapi.dao;

/**
 * Created by null on 2/13/14.
 */
public interface Entity<T extends EntityMetaInfo> {

    T getMetaInfo();
}
