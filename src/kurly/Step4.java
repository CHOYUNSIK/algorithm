package kurly;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Step4 {

    public static void main(String[] args) {


        int[] containers = {8, 11, -9, 2, 5, 18, 17, -15, 4};

        ArrayList<Integer> positiveSizes = new ArrayList<>();
        ArrayList<Integer> negativeSizes = new ArrayList<>();

        for (int container : containers) {
            if (container > 0)
                positiveSizes.add(container);
            else
                negativeSizes.add(container);
        }


        Collections.sort(positiveSizes, Collections.reverseOrder());

        Collections.sort(negativeSizes);

        int currentColor = 1;

        int i = 0;
        int j = 0;

        //18 -15 11 -9 8

        List<Integer> integers = new ArrayList<>();
        int currentSize = 0;

        if (Math.abs(positiveSizes.get(i)) > Math.abs(negativeSizes.get(j))) {
            integers.add(positiveSizes.get(i));
            currentSize = positiveSizes.get(i);
            currentColor = -1;
            i++;
        } else {
            integers.add(negativeSizes.get(i));
            currentSize = Math.abs(negativeSizes.get(j));
            j++;
        }

        while (i < positiveSizes.size() && j < negativeSizes.size()) {

            if (currentColor == 1) {
                if (currentSize > Math.abs(positiveSizes.get(i))) {
                    integers.add(positiveSizes.get(i));
                    currentColor *= -1;
                    currentSize = Math.abs(positiveSizes.get(i));
                }
                i++;
            } else {
                if (currentSize > Math.abs(negativeSizes.get(j))) {
                    integers.add(negativeSizes.get(j));
                    currentColor *= -1;
                    currentSize = Math.abs(negativeSizes.get(j));
                }
                j++;
            }
        }

        while (i < positiveSizes.size() && currentColor == 1) {
            if (currentSize > Math.abs(positiveSizes.get(i))) {
                integers.add(positiveSizes.get(i));
                break;
            }
            i++;
        }

        while (j < positiveSizes.size() && currentColor == -11) {
            if (currentSize > Math.abs(negativeSizes.get(j))) {
                integers.add(negativeSizes.get(j));
                break;
            }
            j++;
        }

        System.out.println(integers.size());
    }


}
