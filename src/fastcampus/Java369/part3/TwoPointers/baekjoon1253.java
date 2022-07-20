
package fastcampus.Java369.part3.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon1253 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(a, 1, N + 1);

        int result = 0;

        for (int T = 1; T <= N; T++) {
            int target = a[T];

            int L = 1, R = N;

            while (L < R) {
                int sum = a[R] + a[L];

                if (L == T) L++;
                else if (R == T) R--;
                else {
                    if (sum > target) {
                        R--;
                    } else if (sum == target) {
                        result++;
                        break;
                    } else {
                        L++;
                    }
                }


            }
        }
        System.out.println(result);
    }
}