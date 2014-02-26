package bynull.akkapulco.api;

/**
 * Created by null on 2/27/14.
 */
public interface Task<T> {
    void execute(T parameter);
}
