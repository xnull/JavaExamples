package bynull.architecture.publicapi.mapping;

/**
 * Created by null on 2/13/14.
 */
public interface Mapper<Source, Destination> {
    Destination map(Source source);
}
