package bynull.bitoperations;

import bynull.Utils.Utils;

/**
 * @author: null
 * Date: 03.02.14
 * Time: 1:26
 */
public class Main {

    public static void main(String[] args) {
        int first = 10;
        int second = 3;
        Utils.print(Integer.toBinaryString(first));
        Utils.print(Integer.toBinaryString(second));
        int result = first << second;
        Utils.print(Integer.toBinaryString(result));
        Utils.print(result);
        Utils.print(first * Math.pow(2, second));
    }
}
