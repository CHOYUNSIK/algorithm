package fastcampus.Java369.part3.Step08_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon2193 {

    static int N;

    static long[][] Dy;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        Dy = new long[N + 1][2];

        Dy[1][1] = 1;

        for (int i = 2; i <= N; i++) {
            Dy[i][0] = Dy[i - 1][0] + Dy[i - 1][1];
            Dy[i][1] = Dy[i - 1][0];
        }

        System.out.println(Dy[N][0] + Dy[N][1]);

    }
}

