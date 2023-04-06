package fastcampus.Java369.naDongbinPackamMaking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class baekjoon22871 {

    static int N;
    static long[] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new long[N];
        dp = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = -1;
        }

        System.out.println(jump(0));


    }

    private static long jump(int x) {

        if (x == N - 1) return 0;
        if (dp[x] != -1) return dp[x];

        dp[x] = Long.MAX_VALUE;

        for (int i = x + 1; i < N; i++) {
            long jump = jump(i);
            long calculation = (i - x) * (1 + Math.abs(arr[x] - arr[i]));

            dp[x] = Math.min(dp[x], Math.max(jump, calculation));
        }

        return dp[x];
    }


}
