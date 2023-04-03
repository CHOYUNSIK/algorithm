package fastcampus.Java369.naDongbinPackamMaking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class baekjoon22869 {

    static int N, K;
    static int[] arr;
    static boolean[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        dp = new boolean[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1);

        System.out.println(dp[N] ? "YES" : "NO");

    }

    private static void dfs(int index) {

        if (index == N) {
            dp[index] = true;
            return;
        }

        if (dp[index]) return;

        dp[index] = true;

        for (int i = index + 1; i <= N; i++) {
            if ((i - index) * (1 + Math.abs(arr[index - 1] - arr[i - 1])) <= K) {
                dfs(i);
            }
        }

    }


}
