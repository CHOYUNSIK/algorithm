package kurly;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Step4 {

    public static void main(String[] args) throws IOException {

        int[] containers = {8, 11, -9, 2, 5, 18, 17, -15, 4};

        int maxFloors = calculateMaxFloors(containers);
        System.out.println(maxFloors);
    }

    private static int calculateMaxFloors(int[] containers) {
        List<Integer> uniqueSizes = new ArrayList<>();

        for (int container : containers) {
            int absSize = Math.abs(container);
            if (!uniqueSizes.contains(absSize)) {
                uniqueSizes.add(absSize);
            }
        }

        Collections.sort(uniqueSizes);

        int maxFloors = 1;
        int currentFloors = 1;

        for (int i = 1; i < uniqueSizes.size(); i++) {
            if (uniqueSizes.get(i) < uniqueSizes.get(i - 1)) {
                currentFloors++;
            }
            maxFloors = Math.max(maxFloors, currentFloors);
        }

        return maxFloors;
    }


}
