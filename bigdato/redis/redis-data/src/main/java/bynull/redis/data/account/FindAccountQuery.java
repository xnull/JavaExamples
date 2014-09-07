package bynull.redis.data.account;

import bynull.redis.data.command.AbstractRedisQuery;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * Created by null on 08.09.14.
 */
public class FindAccountQuery extends AbstractRedisQuery<Long, AccountMetaData, Account> {

    protected FindAccountQuery(StringRedisTemplate redis) {
        super(redis);
    }

    @Override
    public Account execute(AccountMetaData metaData) {
        Account result = new Account();
        getOps(metaData.getName()).get(); //result.name = set value from db etc for all values
        return result;
    }

}
