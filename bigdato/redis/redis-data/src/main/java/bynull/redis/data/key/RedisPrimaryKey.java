package bynull.redis.data.key;

/**
 * Created by null on 07.09.14.
 */
public class RedisPrimaryKey<T> {
    private final String keyName;
    private final T keyValue;

    public RedisPrimaryKey(String keyName, T keyValue) {
        this.keyName = keyName;
        this.keyValue = keyValue;
    }

    public String getPrimaryKey() {
        return keyName + ":" + keyValue;
    }

    public T getKeyVaLue() {
        return keyValue;
    }
}
