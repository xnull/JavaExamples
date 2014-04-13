package bynull.concurrency.safepublication.constructorfint;

import bynull.Utils.Utils;

/**
 * Created by null on 2/8/14.
 */
public class Constructer {

    private Integer item;

    public static class ConstructerHoler {
        public static void setConstructer(Constructer c) {
            if (c.item == null) {
                Utils.print("AXXXXXTUNG!!!");
            }
        }
    }

    public Constructer() {
        ConstructerHoler.setConstructer(this);
        item = 10;
    }

    public static void main(String[] args) {
        new Constructer();
    }
}
