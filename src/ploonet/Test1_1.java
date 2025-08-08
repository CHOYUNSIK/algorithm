package ploonet;

import java.util.Arrays;

public class Test1_1 {

    public int[] solution(int[] degrees){
        int[] result = new int[4];

        int current = 0;
        for (int degree : degrees){
            current = (current + degree) % 360;

            if (current < 90) result[0]++;
            else if (current < 180) result[1]++;
            else if (current < 270) result[2]++;
            else result[3]++;
        }

        return result;

    }
    public static void main(String[] args) {
        Test1_1 sol = new Test1_1();




        System.out.println(Arrays.toString(sol.solution(new int[]{80, 99, 361, 720, 450})));
        System.out.println(Arrays.toString(sol.solution(new int[]{360, 720, 1080, 1440})));
        System.out.println(Arrays.toString(sol.solution(new int[]{10000})));
    }
}
