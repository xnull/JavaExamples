package bynull.redis.data.key;

/**
 * Created by null on 07.09.14.
 */
public abstract class RedisKey<K> {
    private final String keyName;
    private final RedisPrimaryKey<K> pk;

    public RedisKey(String keyName, RedisPrimaryKey<K> pk) {
        this.keyName = keyName;
        this.pk = pk;
    }

    public String getKeyName() {
        return pk.getPrimaryKey() + ":" + keyName;
    }

    public static class ValueRedisKey<T> extends RedisKey<T> {

        public ValueRedisKey(String keyName, RedisPrimaryKey<T> pk) {
            super(keyName, pk);
        }
    }

    public static class ListRedisKey<T> extends RedisKey<T> {

        public ListRedisKey(String keyName, RedisPrimaryKey<T> pk) {
            super(keyName, pk);
        }
    }
}
