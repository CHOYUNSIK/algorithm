package fastcampus.Java369.mockCodingTest1.Step01_CodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class baekjoon20167 {

    static int N, K;
    static long[] arr;
    static long[] dy;

    static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new long[N + 1];
        dy = new long[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        dfs20167(1, 0);

        System.out.println(result);
    }

    private static void dfs20167(int idx, long energy) {
        result = Math.max(result, energy);


        long sum = 0;
        for (int i = idx; i <= N; i++) {
            sum += arr[i];
            if (sum >= K) {
                dfs20167(i + 1, energy + (sum - K));
                break;
            }
        }

        if (idx < N) dfs20167(idx + 1, energy);
    }

}
