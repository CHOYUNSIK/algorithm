package fastcampus.Java369.mockCodingTest1.Step01_CodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon20164 {

    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dfs20164(N, get_odd_cnt(N));
        System.out.println(min + " " + max);
    }

    private static void dfs20164(int n, int total_old_cnt) {

        if (n <= 9) {
            max = Math.max(max, total_old_cnt);
            min = Math.min(min, total_old_cnt);

            return;
        }

        if (n <= 99) {
            int next = (n / 10) + (n % 10);
            dfs20164(next, total_old_cnt + get_odd_cnt(next));
        }

        String s = Integer.toString(n);

        for (int i = 0; i <= s.length() - 3; i++) {
            for (int j = i + 1; j <= s.length() - 2; j++) {
                String x1 = s.substring(0, i + 1);
                String x2 = s.substring(i + 1, j + 1);
                String x3 = s.substring(j + 1);

                int next = Integer.parseInt(x1) + Integer.parseInt(x2) + Integer.parseInt(x3);

                dfs20164(next, get_odd_cnt(next) + total_old_cnt);
            }
        }

    }

    private static int get_odd_cnt(int n) {
        int res = 0;

        while (n > 0) {
            int digit = n % 10;
            if (digit % 2 != 0) res++;
            n /= 10;
        }

        return res;
    }


}
