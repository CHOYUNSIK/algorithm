package fastcampus.Java369.part3.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon2230 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());

        int[] a = new int[N + 1];

        int M = Integer.parseInt(st.nextToken());


        for (int i = 1; i <= N; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }


        Arrays.sort(a, 1, N + 1);

        int R = 1, result = Integer.MAX_VALUE;
        for (int L = 1; L <= N; L++) {

            while (R + 1 <= N && a[R] - a[L] < M) ++R;

            if (a[R] - a[L] >= M) result = Math.min(result, a[R] - a[L]);

        }

        System.out.println(result);

    }
}