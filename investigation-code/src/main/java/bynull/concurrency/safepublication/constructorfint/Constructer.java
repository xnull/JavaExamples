package bynull.concurrency.safepublication.constructorfint;

/**
 * Created by null on 2/8/14.
 */
public class Constructer {

    private Integer item;

    public static class ConstructerHoler{
        public static void setConstructer(Constructer c){
            if (c.item == null){
                System.out.println("AXXXXXTUNG!!!");
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
