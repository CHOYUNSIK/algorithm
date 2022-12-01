package fastcampus.Java369.mockCodingTest.Step01_CodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon20181 {

    static int N, K;
    static long[] arr;
    static long[] dy;

    static ArrayList<long[]>[] list;

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


        list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }


        long sum = 0;
        for (int L = 1, R = 0; L <= N; L++) {

            while (R + 1 <= N && sum < K) sum += arr[++R];

            if (K <= sum) {
                list[R].add(new long[]{L, sum - K});
            }

            sum -= arr[L];

        }


        for (int R = 1; R <= N; R++) {

            dy[R] = dy[R - 1];

            for (long[] x : list[R]) {

                dy[R] = Math.max(dy[R], dy[(int) (x[0]) - 1] + x[1]);
            }
        }


        System.out.println(dy[N]);

    }


}
