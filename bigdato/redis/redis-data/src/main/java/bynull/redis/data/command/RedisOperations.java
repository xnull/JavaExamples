package bynull.redis.data.command;

import bynull.redis.data.key.RedisKey.ListRedisKey;
import bynull.redis.data.key.RedisKey.ValueRedisKey;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * Created by null on 08.09.14.
 */
public abstract class RedisOperations {

    protected final StringRedisTemplate redis;

    protected RedisOperations(StringRedisTemplate redis) {
        this.redis = redis;
    }

    protected BoundValueOperations<String, String> getOps(ValueRedisKey<?> key) {
        return redis.boundValueOps(key.getKeyName());
    }

    protected BoundListOperations<String, String> getOps(ListRedisKey<?> key) {
        return redis.boundListOps(key.getKeyName());
    }
}
