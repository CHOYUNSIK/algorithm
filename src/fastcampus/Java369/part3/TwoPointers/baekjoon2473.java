package fastcampus.Java369.part3.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon2473 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());

        int[] a = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(a, 1, N + 1);

        long bestSum = Long.MAX_VALUE;
        int v1 = 0, v2 = 0, v3 = 0;
        for (int i = 1; i <= N - 2; i++) {
            int L = i + 1;
            int R = N;
            int target = -a[i];

            while (L < R) {
                if (bestSum > Math.abs(-(long) target + a[L] + a[R])) {
                    bestSum = Math.abs(-(long) target + a[L] + a[R]);
                    v1 = a[i];
                    v2 = a[L];
                    v3 = a[R];
                }
                
                if (target < a[L] + a[R]) {
                    R--;
                } else {
                    L++;
                }

            }

        }

        System.out.println(v1 + " " + v2 + " " + v3);

    }
}