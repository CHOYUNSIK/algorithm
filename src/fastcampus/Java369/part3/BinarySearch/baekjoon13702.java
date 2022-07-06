package fastcampus.Java369.part3.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon13702 {

    static int N, K;
    static int[] X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        X = new int[N + 1];
        K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            X[i] = Integer.parseInt(br.readLine());
        }

        long L = 0, R = Integer.MAX_VALUE;
        long result = 0;

        while (L <= R) {
            long mid = (L + R) / 2;

            if (alcoholDistribution(mid)) {
                L = mid + 1;
                result = mid;
            } else {
                R = mid - 1;
            }

        }
        System.out.println(result);
    }

    private static boolean alcoholDistribution(long mid) {

        if (mid == 0) {
            return false;
        }

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += X[i] / mid;
        }
        return sum >= K;
    }


}
