package bynull.architecture.publicapi.dao;

/**
 * Created by null on 2/13/14.
 */
public interface Repository<T extends Entity, E extends MutableEntity<T>> {

    E buildEntity();
}
