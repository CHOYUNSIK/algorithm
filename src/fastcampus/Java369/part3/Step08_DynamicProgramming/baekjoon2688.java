
package fastcampus.Java369.part3.Step08_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon2688 {


    public static void main(String[] args) throws IOException {


        long[][] Dy = new long[65][10];

        for (int i = 0; i <= 9; i++) {
            Dy[1][i] = 1;
        }

        for (int i = 2; i <= 64; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = j; k <= 9; k++) {
                    Dy[i][j] += Dy[i - 1][k];
                }
            }

        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            long sum = 0;
            for (int i = 0; i <= 9; i++) {
                sum += Dy[N][i];
            }

            System.out.println(sum);

        }


    }


}


