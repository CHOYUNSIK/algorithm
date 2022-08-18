package fastcampus.Java369.part3.Step3_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon1920 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] B = new int[M + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A, 1, N + 1);

        for (int i = 1; i <= M; i++) {
            int X = B[i];
            int L = 1;
            int R = N;
            int result = 0;

            while (L <= R) {
                int mid = (L + R) / 2;

                if (A[mid] == X) {
                    result = 1;
                    break;
                }

                if (A[mid] < X) {
                    L = mid + 1;
                } else {
                    R = mid - 1;
                }
            }
            System.out.println(result);


        }

    }

}
