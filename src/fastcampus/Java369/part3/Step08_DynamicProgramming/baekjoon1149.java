
package fastcampus.Java369.part3.Step08_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon1149 {

    static int N;

    static int[] A;
    static int[][] Dy;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        Dy = new int[N + 1][3];

        A = new int[3];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                A[j] = Integer.parseInt(st.nextToken());
            }

            Dy[i][0] = Integer.min(Dy[i - 1][1], Dy[i - 1][2]) + A[0];
            Dy[i][1] = Integer.min(Dy[i - 1][0], Dy[i - 1][2]) + A[1];
            Dy[i][2] = Integer.min(Dy[i - 1][0], Dy[i - 1][1]) + A[2];
        }

        System.out.println(Integer.min(Dy[N][0], Integer.min(Dy[N][1], Dy[N][2])));


    }
}

