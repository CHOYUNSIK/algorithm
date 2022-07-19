package fastcampus.Java369.part3.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon11728 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());

        int[] A = new int[N + 1];

        int M = Integer.parseInt(st.nextToken());

        int[] B = new int[M + 1];


        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }


        StringBuilder sb = new StringBuilder();
        int L = 1, R = 1;

        while (L <= N && R <= M) {
            if (A[L] < B[R]) sb.append(A[L++]).append(" ");
            else sb.append(B[R++]).append(" ");
        }

        while (L <= N) sb.append(A[L++]).append(" ");
        while (R <= M) sb.append(B[R++]).append(" ");

        System.out.println(sb);
    }
}