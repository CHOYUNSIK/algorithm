package inflearn.C_TwoPointersAndSlidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step5_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        /*int[] arr = new int[n / 2 + 1];

        for (int i = 0; i < n / 2 + 1; i++) {
            arr[i] = i + 1;
        }

        int lt = 0, sum = 0, cnt = 0;

        for (int rt = 0; rt < n / 2 + 1; rt++) {
            sum += arr[rt];
            if (sum == n) cnt++;

            while (sum >= n) {
                sum -= arr[lt++];
                if (sum == n) cnt++;
            }
        }

        System.out.println(cnt);*/

        int cnt = 1, result = 0;
        n--;

        while (n > 0) {
            cnt++;
            n -= cnt;
            if (n % cnt == 0) result++;
        }

        System.out.println(result);


    }
}
