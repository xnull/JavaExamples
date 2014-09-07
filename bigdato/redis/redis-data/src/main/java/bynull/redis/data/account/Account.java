package bynull.redis.data.account;

import bynull.redis.data.dbobject.DomainObject;

import java.util.Arrays;
import java.util.List;

/**
 * Created by null on 08.09.14.
 */
public class Account implements DomainObject {
    public String getAccountName() {
        return "test";
    }

    public Integer getAge() {
        return 30;
    }

    public List<Integer> friendsId() {
        return Arrays.asList(1, 2, 3);
    }
}
