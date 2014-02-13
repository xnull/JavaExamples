package bynull.concurrency.safepublication.unsafe;

/**
 * Created by null on 2/8/14.
 */
public class UnsafeObject {

    private Integer age;
    private String name;

    public UnsafeObject(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
