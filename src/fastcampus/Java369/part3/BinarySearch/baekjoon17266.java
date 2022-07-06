package fastcampus.Java369.part3.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon17266 {

    static int N, M;
    static int[] X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        X = new int[M + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= M; i++) {
            X[i] = Integer.parseInt(st.nextToken());
        }

        int L = 0, R = N;
        int result = N;

        while (L <= R) {
            int mid = (L + R) / 2;

            if (lengthCheck(mid)) {
                R = mid - 1;
                result = mid;
            } else {
                L = mid + 1;
            }

        }

        System.out.println(result);

    }

    private static boolean lengthCheck(int mid) {

        int last = 0;

        for (int i = 1; i <= M; i++) {
            if (X[i] - last <= mid) {
                last = X[i] + mid;
            } else {
                return false;
            }

        }


        return last >= N;
    }


}
