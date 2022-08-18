package fastcampus.Java369.part3.Step3_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon2512 {

    static int N, M;
    static int[] X;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        X = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            X[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());

        int L = 1, R = Arrays.stream(X).max().getAsInt();

        int result = 0;

        while (L <= R) {
            int mid = (L + R) / 2;
            if (checkTheValueDistribution(mid)) {
                result = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }

        System.out.println(result);

    }

    private static boolean checkTheValueDistribution(int mid) {

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            if (X[i] <= mid) {
                sum += X[i];
            } else {
                sum += mid;
            }
        }

        return sum <= M;
    }

}
