package fastcampus.Java369.naDongbinPackamMaking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class baekjoon21774 {

    static long[] logs;
    static int[] lv;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        logs = new long[N + 2];
        logs[N + 1] = Integer.MAX_VALUE;
        lv = new int[N + 1];
        dp = new int[N + 1][7];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), "#");
            logs[i] = Long.parseLong(st.nextToken().replaceAll("[- :]", ""));
            lv[i] = Integer.parseInt(st.nextToken());
            for (int j = lv[i]; j >= 1; j--) {
                dp[i][j]++;
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= 6; j++) {
                dp[i][j] += dp[i - 1][j];
            }
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine(), "#");
            long start = Long.parseLong(st.nextToken().replaceAll("[- :]", ""));
            long end = Long.parseLong(st.nextToken().replaceAll("[- :]", ""));
            int qLv = Integer.parseInt(st.nextToken());

            int lower = lowerBound(1, N + 1, start);
            int upper = upperBound(1, N + 1, end);

            System.out.println(dp[upper - 1][qLv] - dp[lower - 1][qLv]);

        }

    }

    private static int upperBound(int left, int right, long target) {

        while (left < right) {
            int mid = (left + right) / 2;

            if (target >= logs[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }

    private static int lowerBound(int left, int right, long target) {

        while (left < right) {
            int mid = (left + right) / 2;

            if (target <= logs[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }


}
