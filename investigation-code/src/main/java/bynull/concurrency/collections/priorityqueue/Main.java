package bynull.concurrency.collections.priorityqueue;

import java.util.*;

/**
 * Created by null on 2/26/14.
 */
public class Main {

    private static class MyObject implements Comparable<MyObject>{
        private final int priority;

        private MyObject(int priority) {
            this.priority = priority;
        }

        @Override
        public int compareTo(MyObject o) {
            if (priority > o.priority){
                return 1;
            }

            if (priority < o.priority){
                return -1;
            }

            return 0;
        }
    }

    public static void main(String[] args) {

        Random rnd = new Random();

        Collection<MyObject> cache = new ArrayList<>();
        System.out.print("cache: ");
        for (int i = 0; i < 10; i++) {
            MyObject myObj = new MyObject(rnd.nextInt(100));
            System.out.print(myObj.priority + ", ");
            cache.add(myObj);
        }

        PriorityQueue<MyObject> queue = new PriorityQueue<>();
        queue.addAll(cache);

        while(true){
            MyObject queueObj = queue.poll();
            if (queueObj == null){
                break;
            }
            System.out.println(queueObj.priority);
        }
    }
}
