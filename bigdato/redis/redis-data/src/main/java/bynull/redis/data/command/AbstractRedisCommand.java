package bynull.redis.data.command;

import bynull.redis.data.dbobject.DomainObject;
import bynull.redis.data.dbobject.DomainObjectMetaData;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * Created by null on 07.09.14.
 */
public abstract class AbstractRedisCommand<K, T extends DomainObjectMetaData<K>, D extends DomainObject> extends RedisOperations {

    protected AbstractRedisCommand(StringRedisTemplate redis) {
        super(redis);
    }

    public abstract void execute(T metaData, D data);
}
