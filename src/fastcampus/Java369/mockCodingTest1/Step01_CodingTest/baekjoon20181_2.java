package fastcampus.Java369.mockCodingTest1.Step01_CodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon20181_2 {

    static int N, K;
    static long[] arr;
    static long[] dy;

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

        int right = 1;
        long sum = 0, dyLeftMax = 0;

        for (int left = 1; left <= N; left++) {
            dyLeftMax = Math.max(dyLeftMax, dy[left - 1]);

            while (right <= N && sum < K) {
                sum += arr[right++];
            }

            if (sum >= K) {
                dy[right - 1] = Math.max(dy[right - 1], dyLeftMax + (sum - K));
            } else {
                break;
            }

            sum -= arr[left];

        }

        long result = 0;

        for (int i = 1; i <= N; i++) {
            result = Math.max(result, dy[i]);
        }

        System.out.println(result);


    }


}
