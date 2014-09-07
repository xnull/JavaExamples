package bynull.redis.data.account;

import bynull.redis.data.dbobject.DomainObjectMetaData;
import bynull.redis.data.key.RedisKey.ListRedisKey;
import bynull.redis.data.key.RedisKey.ValueRedisKey;
import bynull.redis.data.key.RedisPrimaryKey;

/**
 * Created by null on 08.09.14.
 */
public class AccountMetaData extends DomainObjectMetaData<Long> {

    private final ValueRedisKey<Long> name;
    private final ValueRedisKey<Long> age;
    private final ListRedisKey<Long> friends;

    public AccountMetaData(RedisPrimaryKey<Long> pk) {
        super(pk);
        name = new ValueRedisKey<>("name", pk);
        age = new ValueRedisKey<>("age", pk);
        friends = new ListRedisKey<>("friends", pk);
    }

    public ValueRedisKey<Long> getName() {
        return name;
    }

    public ValueRedisKey<Long> getAge() {
        return age;
    }

    public ListRedisKey<Long> getFriends() {
        return friends;
    }
}
