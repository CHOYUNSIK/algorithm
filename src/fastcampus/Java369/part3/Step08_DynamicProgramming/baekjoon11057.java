
package fastcampus.Java369.part3.Step08_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon11057 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] Dy = new int[N + 1][10];

        for (int i = 0; i <= 9; i++) {
            Dy[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= j; k++) {
                    Dy[i][j] += Dy[i - 1][k];
                    Dy[i][j] %= 10007;
                }
            }
        }

        int result = 0;

        for (int i = 0; i <= 9; i++) {
            result += Dy[N][i];
            result %= 10007;
        }

        System.out.println(result);

    }


}


