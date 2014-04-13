package bynull.datastructure.sortalgorithms.quicksort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by null on 4/12/14.
 */
public class Main {

    public static void main(String[] args) {
        List<Integer> unsortedList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            unsortedList.add(new Random().nextInt(100));
        }

        quickSort(unsortedList, 0, unsortedList.size() - 1  );

        System.out.println(unsortedList);
    }

    private static void quickSort(List<Integer> unsortedList, int low, int high) {
        int mediana = unsortedList.get(low + (high - low) / 2);

        int i = low, j = high;
        while (low <= high) {
            while (unsortedList.get(i) < mediana) {
                i++;
            }
            while (unsortedList.get(j) > mediana) {
                j++;
            }

            if (i <= j) {
                Integer highElement = unsortedList.get(i);
                Integer lowElement = unsortedList.get(j);
                unsortedList.set(i, lowElement);
                unsortedList.set(j, highElement);

                i++;
                j++;
            }
        }

        if (low < j) {
            quickSort(unsortedList, low, j);
        }

        if (i < high) {
            quickSort(unsortedList, i, high);
        }
    }
}
