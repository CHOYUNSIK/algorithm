package fastcampus.Java369.part3.Step3_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon2805 {

    static int N, M;
    static int[] X;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        X = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= N; i++) {
            X[i] = Integer.parseInt(st.nextToken());
        }


        int L = 1, R = 2000000000;

        int result = 0;

        while (L <= R) {
            int mid = (L + R) / 2;
            if (checkLength(mid)) {
                L = mid + 1;
                result = mid;
            } else {
                R = mid - 1;
            }
        }

        System.out.println(result);

    }


    static boolean checkLength(int H) {
        long sum = 0;
        for (int i = 1; i <= N; i++) {
            if (X[i] > H) {
                sum += X[i] - H;
            }
        }
        return sum >= M;
    }

}
