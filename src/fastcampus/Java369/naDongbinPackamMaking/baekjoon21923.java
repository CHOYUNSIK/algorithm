package fastcampus.Java369.naDongbinPackamMaking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon21923 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N + 2][M + 2];
        long[][] leftToRight = new long[N + 2][M + 2];
        long[][] rightToLeft = new long[N + 2][M + 2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i <= N + 1; i++) {
            for (int j = 0; j <= M + 1; j++) {
                leftToRight[i][j] = Long.MIN_VALUE / 2;
                rightToLeft[i][j] = Long.MIN_VALUE / 2;
            }
        }

        leftToRight[N][1] = arr[N][1];
        rightToLeft[N][M] = arr[N][M];

        for (int i = N; i >= 1; i--) {
            for (int j = 1; j <= M; j++) {
                if (i == N && j == 1) continue;
                leftToRight[i][j] = Math.max(leftToRight[i + 1][j], leftToRight[i][j - 1]) + arr[i][j];
            }
        }

        for (int i = N; i >= 1; i--) {
            for (int j = M; j >= 1; j--) {
                if (i == N && j == M) continue;
                rightToLeft[i][j] = Math.max(rightToLeft[i + 1][j], rightToLeft[i][j + 1]) + arr[i][j];
            }
        }

        long result = Long.MIN_VALUE / 2;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                result = Math.max(result, leftToRight[i][j] + rightToLeft[i][j]);
            }
        }

        System.out.println(result);

    }


}
