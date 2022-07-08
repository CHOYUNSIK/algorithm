package fastcampus.Java369.part3.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon2003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int[] a = new int[N + 1];
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int R = 0, result = 0, sum = 0;

        for (int L = 1; L <= N; L++) {

            sum -= a[L - 1];

            while (R + 1 <= N && sum < M) {
                sum += a[++R];
            }

            if (sum == M) {
                result++;
            }

        }

        System.out.println(result);

    }
}