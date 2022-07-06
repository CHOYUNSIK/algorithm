package fastcampus.Java369.part3.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon2110 {

    static int N, C;
    static int[] X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());

        X = new int[N + 1];

        C = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            X[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(X, 1, N + 1);

        int L = 1, R = 1000000000;
        int result = 0;

        while (L <= R) {
            int mid = (L + R) / 2;
            if (distanceMeasurement(mid)) {
                L = mid + 1;
                result = mid;
            } else {
                R = mid - 1;
            }
        }

        System.out.println(result);

    }

    private static boolean distanceMeasurement(int mid) {

        int last = X[1];
        int cnt = 1;

        for (int i = 2; i <= N; i++) {
            if (X[i] - last < mid) continue;
            last = X[i];
            cnt++;
        }
        return cnt >= C;
    }


}
