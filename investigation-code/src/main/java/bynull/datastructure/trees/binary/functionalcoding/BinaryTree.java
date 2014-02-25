package bynull.datastructure.trees.binary.functionalcoding;

/**
 * http://samolisov.blogspot.ru/2010/03/java_27.html
 * Created by null on 2/23/14.
 */
public interface BinaryTree {

    <T> T match(F<? super Empty, T> a, F<? super Leaf, T> b, F<? super Node, T> c);

    public static final class Node implements BinaryTree {
        public final BinaryTree left;
        public final BinaryTree right;

        public <T> T match(F<? super Empty, T> a, F<? super Leaf, T> b, F<? super Node, T> c) {
            return c.f(this);
        }

        public Node(BinaryTree left, BinaryTree right) {
            if (left == null || right == null) {
                throw new IllegalArgumentException("subtrees could not be null, they must be a Leaf or an Empty");
            }

            this.left = left;
            this.right = right;
        }
    }

    public static final class Leaf implements BinaryTree {
        private final int n;

        public <T> T match(F<? super Empty, T> a, F<? super Leaf, T> b, F<? super Node, T> c) {
            return b.f(this);
        }

        public Leaf(int n) {
            this.n = n;
        }
    }

    public static final class Empty implements BinaryTree {
        public <T> T match(F<? super Empty, T> a, F<? super Leaf, T> b, F<? super Node, T> c) {
            return a.f(this);
        }
    }

}
