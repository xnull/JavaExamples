package bynull.datastructure.trees.binary.functionalcoding;

import bynull.datastructure.trees.binary.functionalcoding.BinaryTree.Empty;
import bynull.datastructure.trees.binary.functionalcoding.BinaryTree.Leaf;
import bynull.datastructure.trees.binary.functionalcoding.BinaryTree.Node;

/**
 * Created by null on 2/23/14.
 */
public class Main {

    public static void main(String[] args) {
        BinaryTree tree = new Node(
                new Node(
                        new Node(
                                new Leaf(10), new Leaf(5)
                        ),
                        new Leaf(6)
                ),
                new Node(
                        new Leaf(5), new Empty()
                )
        );
    }
}
