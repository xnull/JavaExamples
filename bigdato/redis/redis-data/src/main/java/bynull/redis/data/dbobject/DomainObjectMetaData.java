package bynull.redis.data.dbobject;

import bynull.redis.data.key.RedisPrimaryKey;

/**
 * Created by null on 08.09.14.
 */
public abstract class DomainObjectMetaData<K> {
    private final RedisPrimaryKey<K> pk;

    public DomainObjectMetaData(RedisPrimaryKey<K> pk) {
        this.pk = pk;
    }


}
