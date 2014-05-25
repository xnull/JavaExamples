package bynull.bitoperations;

/**
 * Created by null on 23.05.14.
 */
public class BitOperations {

    public static void main(String[] args) {
        System.out.println(divideInHalf(10));
    }

    /**
     * Знаковый оператор сдвига вправо
     * Операция используется для быстрого деления на 2
     * @param number
     * @return
     */
    private static int divideInHalf(int number){
        return number >> 1;
    }
}
