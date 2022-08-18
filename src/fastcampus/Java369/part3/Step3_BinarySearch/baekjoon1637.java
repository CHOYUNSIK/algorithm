package fastcampus.Java369.part3.Step3_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon1637 {

    static int N;
    static int[][] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        A = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long L = 1, R = Integer.MAX_VALUE, result = 0, count = 0;

        while (L <= R) {
            long mid = (L + R) / 2;

            if (numCheck((int) mid)) {
                R = mid - 1;
                result = mid;
            } else {
                L = mid + 1;
            }
        }


        if (result == 0) {
            System.out.println("NOTHING");
        } else {
            for (int i = 1; i <= N; i++) {
                if (result >= A[i][0] && result <= A[i][1] && (result - A[i][0]) % A[i][2] == 0) {
                    count++;
                }
            }
            System.out.println(result + " " + count);
        }


    }

    private static boolean numCheck(int mid) {

        long sum = 0;

        for (int i = 1; i <= N; i++) {
            sum += countNum(A[i][0], A[i][1], A[i][2], mid);
        }

        return sum % 2 == 1;
    }

    private static int countNum(int A, int C, int B, int X) {
        if (X < A) return 0;
        if (C < X) return (C - A) / B + 1;
        return (X - A) / B + 1;
    }

}
