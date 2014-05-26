package bynull.collections;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by null on 25.05.14.
 */
public class TreeMapTest {

    public static void main(String[] args) {
        TreeMap<String, Integer> mapa = new TreeMap<>();
        mapa.put("3three", 1);
        mapa.put("2two", 2);
        mapa.put("1one", 3);
F
        for (Map.Entry<String, Integer> el: mapa.entrySet()){
            System.out.println(el.getKey());
        }
    }
}
