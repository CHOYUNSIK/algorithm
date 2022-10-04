
package fastcampus.Java369.part3.Step08_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon2579 {
    static int[][] Dy;
    static int N;

    static int[] score;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        score = new int[N + 1];
        Dy = new int[N + 1][2];

        for (int i = 1; i <= N; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        Dy[1][0] = 0;
        Dy[1][1] = score[1];

        if (N >= 2){
            Dy[2][0] = score[2];
            Dy[2][1] = score[1] + score[2];
        }


        for (int i = 3; i <= N; i++) {
            Dy[i][0] = Math.max(Dy[i - 2][0] + score[i], Dy[i - 2][1] + score[i]);
            Dy[i][1] = Dy[i - 1][0] + score[i];
        }

        System.out.println(Math.max(Dy[N][0], Dy[N][1]));
    }
}

