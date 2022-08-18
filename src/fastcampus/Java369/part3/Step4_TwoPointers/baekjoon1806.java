package fastcampus.Java369.part3.Step4_TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon1806 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];

        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int R = 0, sum = 0, result = N + 1;

        for (int L = 1; L <= N; L++) {

            sum -= arr[L - 1];

            while (R + 1 <= N && sum < S) {
                sum += arr[++R];
            }

            if (sum >= S) {
                result = Math.min(result, R - L + 1);
            }

        }

        if (N + 1 == result) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }

    }
}