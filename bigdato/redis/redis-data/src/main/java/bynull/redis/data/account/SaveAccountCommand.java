package bynull.redis.data.account;

import bynull.redis.data.command.AbstractRedisCommand;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * Created by null on 08.09.14.
 */
public class SaveAccountCommand extends AbstractRedisCommand<Long, AccountMetaData, Account> {

    public SaveAccountCommand(StringRedisTemplate redis) {
        super(redis);
    }

    @Override
    public void execute(AccountMetaData metaData, Account data) {
        getOps(metaData.getName()).set(data.getAccountName());
        getOps(metaData.getAge()).set(data.getAge().toString());
        getOps(metaData.getFriends()).rightPush(data.friendsId().get(0).toString());
    }
}
