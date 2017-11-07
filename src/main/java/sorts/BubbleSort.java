package sorts;

import utilities.Utils;

/**
 * BubbleSort. Created on 07 Nov 2017 11:56:35 AM by siD.
 *
 * @author Matthew Van der Bijl
 * @sinse 07 Nov 2017
 */
public class BubbleSort {

    /**
     * @param args Arguments from the command line
     */
    public static void main(String[] args) {
        new BubbleSort().run();
    }

    public BubbleSort() {
    }

    public void run() {
        int[] arr = Utils.getRandomArrayOfInts(5);

        System.out.println("Unsorted:");
        for (int i : arr) {
            System.out.println(i);
        }
        System.out.println("");

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        System.out.println("Sorted:");
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
