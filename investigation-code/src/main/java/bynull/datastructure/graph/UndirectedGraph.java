package bynull.datastructure.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by null on 2/23/14.
 */
public class UndirectedGraph {
    private Set<UndirectedGraph> edges = new HashSet<>();

    public void addEdge(UndirectedGraph edge) {
        edges.add(edge);
    }
}
