package fastcampus.Java369.naDongbinPackamMaking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class baekjoon21943 {

    static int N, P, Q;
    static int[] arr;
    static int[] choice;
    static int[] operation;
    static boolean[] used;
    static long[] value;
    static long result = Long.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        choice = new int[N];
        operation = new int[N];
        used = new boolean[N];
        value = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");

        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        dfs(0);
        System.out.println(result);

    }

    private static void dfs(int cnt) {

        if (cnt == N) {
            dfs2(0);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (used[i]) continue;
            used[i] = true;
            choice[cnt] = arr[i];
            dfs(cnt + 1);
            used[i] = false;
        }


    }

    private static void dfs2(int cnt) {

        if (N - 1 == cnt) {
            int idx = -1;
            value[++idx] = choice[0];
            for (int i = 1; i < N; i++) {
                if (operation[i - 1] == 1) value[++idx] = choice[i];
                else value[idx] += choice[i];
            }

            long curValue = 1;
            for (int i = 0; i <= idx; i++) {
                curValue *= value[i];
            }
            result = Math.max(result, curValue);
            return;
        }

        if (P > 0) {
            P--;
            operation[cnt] = 0;
            dfs2(cnt + 1);
            P++;
        }

        if (Q > 0) {
            Q--;
            operation[cnt] = 1;
            dfs2(cnt + 1);
            Q++;
        }

    }

}
