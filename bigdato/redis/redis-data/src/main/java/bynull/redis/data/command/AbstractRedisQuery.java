package bynull.redis.data.command;

import bynull.redis.data.dbobject.DomainObject;
import bynull.redis.data.dbobject.DomainObjectMetaData;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * Created by null on 07.09.14.
 */
public abstract class AbstractRedisQuery<K, T extends DomainObjectMetaData<K>, D extends DomainObject> extends RedisOperations {

    protected AbstractRedisQuery(StringRedisTemplate redis) {
        super(redis);
    }

    public abstract D execute(T metaData);
}
