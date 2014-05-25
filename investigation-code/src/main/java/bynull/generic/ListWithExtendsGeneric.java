package bynull.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by null on 23.05.14.
 */
public class ListWithExtendsGeneric {

    public static void main(String[] args) {
        List<A> list = new ArrayList<A>();
        list.add(new B());
    }

    private static class A {
    }

    private static class B extends A {
    }
}
