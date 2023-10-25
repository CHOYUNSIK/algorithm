package inflearn.B_Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step4_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

/*        int[] arr = new int[n + 1];

        arr[0] = 1;
        arr[1] = 1;

        for (int i = 2; i < 10; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        for (int i = 0; i < 10; i++) {
            System.out.print(arr[i] + " ");
        }*/


/*        int a = 1;
        int b = 1;

        StringBuilder stringBuilder = new StringBuilder().append(a).append(" ").append(b).append(" ");

        for (int i = 2; i < 10; i++) {
            int c = a + b;
            stringBuilder.append(c).append(" ");
            a = b;
            b = c;
        }

        System.out.println(stringBuilder);*/


        for (int i = 0; i < 10; i++){
            System.out.print(fibonacci(i)+ " ");
        }

    }

    private static int fibonacci(int n) {

        if (n <= 1) {
            return 1;
        }

        return fibonacci(n - 2) + fibonacci(n - 1);
    }
}
