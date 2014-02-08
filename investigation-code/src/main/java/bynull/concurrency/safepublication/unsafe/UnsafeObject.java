package bynull.concurrency.safepublication.unsafe;

import java.util.concurrent.TimeUnit;

/**
 * Created by null on 2/8/14.
 */
public class UnsafeObject {

    private Integer age;
    private String name;

    public UnsafeObject(Integer age, String name) {
        this.age = age;
        this.name = name;

        //sleeping();
    }

    private void sleeping() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
