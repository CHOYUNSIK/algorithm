
package fastcampus.Java369.part3.Step08_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon9465 {

    static int T;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][N + 1];
            int[][] Dy = new int[2][N + 1];

            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 1; j <= N; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            Dy[0][1] = sticker[0][1];
            Dy[1][1] = sticker[1][1];

            for (int i = 2; i <= N; i++) {
                Dy[0][i] = Math.max(Dy[1][i - 1], Dy[1][i - 2]) + sticker[0][i];
                Dy[1][i] = Math.max(Dy[0][i - 1], Dy[0][i - 2]) + sticker[1][i];
            }

            System.out.println(Math.max(Dy[1][N], Dy[0][N]));

        }

    }
}

