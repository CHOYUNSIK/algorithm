package fastcampus.Java369.part3.Step3_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon1300 {

    static int N, K;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());


        long L = 1, R = (long) N * N, result = 0;

        while (L <= R) {
            long mid = (L + R) / 2;

            if (obtainingAValue(mid)) {
                result = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }

        }

        System.out.println(result);
    }

    private static boolean obtainingAValue(long mid) {

        long sum = 0;

        for (int i = 1; i <= N; i++) {
            sum += Math.min(N, mid / i);
        }

        return sum >= K;
    }


}
