package bynull.datastructure.trees.binary;

/**
 * Created by null on 2/6/14.
 */
public class Tree<T> {

    public static class Node<T> {
        private Integer index;
        private T value;

        private Node<T> left;
        private Node<T> right;


        public Node(Integer index, T value) {
            this.index = index;
            this.value = value;
        }
    }

    private Node<T> root;

    public Tree(Node<T> root) {
        this.root = root;
    }

    public T get(Integer index) {
        return get(root, index);
    }

    public void add(Node<T> node) {
        //if (n)
    }

    private void add(Node<T> node, Integer index, T value) {
        if (node.index.equals(index)) {
            node.value = value;
        }

        if (index > node.index) {
            add(node.right, index, value);
        }

        if (index < node.index) {
            add(node.left, index, value);
        }
    }

    private T get(Node<T> node, Integer index) {
        if (node.index.equals(index)) {
            return node.value;
        }

        if (index > node.index) {
            return get(node.right, index);
        }

        if (index < node.index) {
            return get(node.left, index);
        }

        return null;
    }
}