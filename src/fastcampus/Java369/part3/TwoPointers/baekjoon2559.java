package fastcampus.Java369.part3.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon2559 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[N + 1];
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }


        int R = 0, result = Integer.MIN_VALUE, sum = 0;
        for (int L = 1; L + K - 1 <= N; L++) {

            sum -= A[L - 1];


            while (R + 1 <= L + K - 1) {
                sum += A[++R];
            }


            result = Math.max(result, sum);

        }

        System.out.println(result);

    }
}