package fastcampus.Java369.part3.Step4_TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon15565 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());

        int[] a = new int[N + 1];

        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int R = 0, count = 0, length = Integer.MAX_VALUE;

        for (int L = 1; L <= N; L++) {

            if (a[L - 1] == 1) count--;

            while (K > count && R + 1 <= N) {
                if (a[++R] == 1) count++;
            }

            if (K == count) {
                length = Math.min(length, R - L + 1);
            }

        }

        if (length == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(length);
        }


    }
}