package kurly;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Step3 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> cycleLengths = new HashMap<>();

        int maxCycleLength = 0;


        for (int i = a; i <= b; i++) {
            int num = i;
            int cycleLength = 1;

            while (num != 1) {
                if (cycleLengths.containsKey(num)) {
                    cycleLength += cycleLengths.get(num) - 1;
                    break;
                }

                if (num % 2 == 0) {
                    num /= 2;
                } else {
                    num = num * 3 + 1;
                }
                cycleLength++;
            }

            cycleLengths.put(i, cycleLength);

            if (cycleLength > maxCycleLength) {
                maxCycleLength = cycleLength;

            }
        }

        System.out.println(maxCycleLength);

    }



}
