package bynull.bitoperations;

/**
 * @author: null
 * Date: 03.02.14
 * Time: 1:26
 */
public class Main {

    public static void main(String[] args) {
        int first = 10;
        int second = 3;
        System.out.println(Integer.toBinaryString(first));
        System.out.println(Integer.toBinaryString(second));
        int result = first << second;
        System.out.println(Integer.toBinaryString(result));
        System.out.println(result);
        System.out.println(first * Math.pow(2, second));
    }
}
