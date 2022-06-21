package fastcampus.Java369.part3.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon7795 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] A;
        int[] B;

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            A = new int[N + 1];
            B = new int[M + 1];

            st = new StringTokenizer(br.readLine(), " ");
            for (int a = 1; a <= N; a++) {
                A[a] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine(), " ");
            for (int b = 1; b <= M; b++) {
                B[b] = Integer.parseInt(st.nextToken());
            }

            // B 배열에 대해 이분탐색을 할 예정이니까, 정렬을 해주자!
            Arrays.sort(B, 1, M + 1);


            int result = 0;

            for (int j = 1; j <= N; j++) {

                int X = A[j];
                int res = 0; // 만약 A[L...R] 중 X 이하의 수가 없다면 0 을 return 한다.
                int L = 1;
                int R = M;

                while (L <= R) {
                    int mid = (L + R) / 2;
                    if (B[mid] < X) {
                        res = mid;
                        L = mid + 1;
                    } else {
                        R = mid - 1;
                    }

                }
                result += res;
            }

            System.out.println(result);

        }

    }

}
