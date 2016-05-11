package bynull.poi;

import java.util.Map;

/**
 * Created by null on 3/25/16.
 */
public class Poi {
    private final GeoPoint geoPoint;
    private final Integer floorNumber;
    private final Map<String, ?> properties;

    public Poi(GeoPoint geoPoint, Integer floorNumber, Map<String, ?> properties) {
        this.geoPoint = geoPoint;
        this.floorNumber = floorNumber;
        this.properties = properties;
    }
}
