
package fastcampus.Java369.part3.Step08_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon1309 {


    static int[][] Dy;
    static int N;

    static final int MOD = 9901;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        Dy = new int[N + 1][3];


        Dy[1][0] = Dy[1][1] = Dy[1][2] = 1;

        for (int i = 2; i <= N; i++) {

            Dy[i][0] = (Dy[i - 1][0] + Dy[i - 1][1] + Dy[i - 1][2]) % MOD;
            Dy[i][1] = (Dy[i - 1][0] + Dy[i - 1][2]) % MOD;
            Dy[i][2] = (Dy[i - 1][0] + Dy[i - 1][1]) % MOD;

        }

        System.out.println((Dy[N][0] + Dy[N][1] + Dy[N][2]) % MOD);


    }


}

