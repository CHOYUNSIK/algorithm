package fastcampus.Java369.part3.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon1654 {

    static int N, K;
    static int[] X;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        X = new int[K + 1];

        for (int i = 1; i <= K; i++) {
            X[i] = Integer.parseInt(br.readLine());
        }


        long L = 1;
        long R = Integer.MAX_VALUE;
        long result = 0;

        while (L <= R) {
            long mid = (L + R) / 2;
            if (crop(mid)) {
                L = mid + 1;
                result = mid;
            } else {
                R = mid - 1;
            }
        }

        System.out.println(result);

    }

    static boolean crop(long H) {
        int count = 0;
        for (int i = 1; i <= K; i++) {
            count += X[i] / H;
        }
        return count >= N;
    }

}
