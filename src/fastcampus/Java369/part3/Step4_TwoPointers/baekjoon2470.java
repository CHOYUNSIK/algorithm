package fastcampus.Java369.part3.Step4_TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon2470 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a, 1, N + 1);

        int L = 1, R = N, result = Integer.MAX_VALUE;
        int resultL = 0, resultR = 0;

        while (L < R) {
            if (result > Math.abs(a[R] + a[L])) {
                result = Math.abs(a[R] + a[L]);
                resultL = a[L];
                resultR = a[R];
            }

            if (a[L] + a[R] > 0) R--;
            else L++;

        }

        System.out.println(resultL + " " + resultR);


    }
}