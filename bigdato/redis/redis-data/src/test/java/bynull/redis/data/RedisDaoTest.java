package bynull.redis.data;

import bynull.redis.data.account.Account;
import bynull.redis.data.account.AccountMetaData;
import bynull.redis.data.account.SaveAccountCommand;
import bynull.redis.data.key.RedisPrimaryKey;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * Created by null on 07.09.14.
 */
public class RedisDaoTest {

    @Test
    public void testSave() {
        RedisPrimaryKey<Long> pk = new RedisPrimaryKey<>("account", 1L);
        AccountMetaData accountMetaData = new AccountMetaData(pk);

        Account account = new Account();

        StringRedisTemplate redis = Mockito.mock(StringRedisTemplate.class);

        new SaveAccountCommand(redis).execute(accountMetaData, account);

    }

    @Test
    public void testFind() {
        RedisPrimaryKey<Long> pk = new RedisPrimaryKey<>("account", 1L);
        AccountMetaData accountMetaData = new AccountMetaData(pk);

        Account account = new Account();

        StringRedisTemplate redis = Mockito.mock(StringRedisTemplate.class);

        new SaveAccountCommand(redis).execute(accountMetaData, account);

    }
}
