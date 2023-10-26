package inflearn.B_Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step5_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];

        int result = 0;

        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0) result++;

            for (int j = i; j <= n; j = j + i) {
                arr[j] = 1;
            }

        }

        System.out.println(result);
    }
}

