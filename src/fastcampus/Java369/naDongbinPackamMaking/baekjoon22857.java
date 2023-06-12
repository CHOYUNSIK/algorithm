package fastcampus.Java369.naDongbinPackamMaking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon22857 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] DP = new int[K + 1][N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (x % 2 == 0) DP[0][i] = DP[0][i - 1] + 1;

            for (int j = 1; j <= K; j++) {
                if (x % 2 == 0) DP[j][i] = DP[j][i - 1] + 1;
                else DP[j][i] = DP[j - 1][i - 1];
            }

        }


        int result = 0;
        for (int i = 1; i <= N; i++) {
            result = Math.max(result, DP[K][i]);
        }
        System.out.println(result);

    }


}
