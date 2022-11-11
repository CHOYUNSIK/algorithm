
package fastcampus.Java369.part3.Step08_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon11049 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] Dy = new int[N][N];

        int[][] mat = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            mat[i][0] = Integer.parseInt(st.nextToken());
            mat[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N - 1; i++) {
            Dy[i][i + 1] = mat[i][0] * mat[i][1] * mat[i + 1][1];
        }

        for (int len = 2; len < N; len++) {
            for (int i = 0; i + len < N; i++) {
                int j = i + len;
                Dy[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    Dy[i][j] = Math.min(Dy[i][j], Dy[i][k] + Dy[k + 1][j] + (mat[i][0] * mat[k][1] * mat[j][1]));
                }
            }
        }

        System.out.println(Dy[0][N - 1]);

    }


}

