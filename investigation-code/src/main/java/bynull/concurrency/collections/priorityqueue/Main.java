package bynull.concurrency.collections.priorityqueue;

import bynull.Utils.Utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Created by null on 2/26/14.
 */
public class Main {

    private static class MyObject implements Comparable<MyObject> {
        private final int priority;

        private MyObject(int priority) {
            this.priority = priority;
        }

        @Override
        public int compareTo(MyObject o) {
            if (priority > o.priority) {
                return 1;
            }

            if (priority < o.priority) {
                return -1;
            }

            return 0;
        }
    }

    public static void main(String[] args) {

        Random rnd = new Random();

        PriorityQueue<MyObject> queue = new PriorityQueue<>();
        //queue.addAll(cache);
        for (int i = 0; i < 10; i++) {
            queue.add(new MyObject(rnd.nextInt(100)));
        }

        while (true) {
            MyObject queueObj = queue.poll();
            if (queueObj == null) {
                break;
            }
            Utils.print(queueObj.priority);
        }
    }
}
