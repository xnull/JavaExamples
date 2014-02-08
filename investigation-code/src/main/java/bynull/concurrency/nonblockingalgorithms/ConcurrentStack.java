package bynull.concurrency.nonblockingalgorithms;

import java.util.concurrent.atomic.AtomicReference;

/**
 * http://www.ibm.com/developerworks/ru/library/j-jtp04186/
 * Created by null on 2/8/14.
 */
public class ConcurrentStack<E> {
    AtomicReference<Node<E>> head = new AtomicReference<>();

    public void push(E item) {
        Node<E> newHead = new Node<E>(item);
        Node<E> oldHead;
        do {
            oldHead = head.get();
            newHead.next = oldHead;
        } while (!head.compareAndSet(oldHead, newHead));
    }

    public E pop() {
        Node<E> oldHead;
        Node<E> newHead;
        do {
            oldHead = head.get();
            if (oldHead == null)
                return null;
            newHead = oldHead.next;
        } while (!head.compareAndSet(oldHead, newHead));
        return oldHead.item;
    }

    static class Node<E> {
        final E item;
        Node<E> next;

        public Node(E item) {
            this.item = item;
        }
    }
}