
package fastcampus.Java369.part3.Step08_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon1562 {

    static final int MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][][] Dy = new long[N + 1][10][1 << 10];

        for (int i = 1; i <= 9; i++) {
            Dy[1][i][1 << i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int k = 0; k <= 9; k++) {
                for (int visit = 0; visit < (1 << 10); visit++) {
                    int newVisit = visit | (1 << k);
                    if (k == 0) {
                        Dy[i][k][newVisit] += Dy[i - 1][k + 1][visit] % MOD;
                    } else if (k == 9) {
                        Dy[i][k][newVisit] += Dy[i - 1][k - 1][visit] % MOD;
                    } else {
                        Dy[i][k][newVisit] += Dy[i - 1][k - 1][visit] % MOD + Dy[i - 1][k + 1][visit] % MOD;
                    }

                }
            }
        }

        long sum = 0;

        for (int i = 0; i <= 9; i++) {
            sum += Dy[N][i][(1 << 10) - 1] % MOD;
            sum %= MOD;
        }

        System.out.println(sum);


    }


}


