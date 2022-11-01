
package fastcampus.Java369.part3.Step08_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon5557 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] Dy = new long[N + 1][21];
        int[] A = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Dy[1][A[1]] = 1;

        for (int i = 2; i < N; i++) {
            for (int j = 0; j <= 20; j++) {
                for (int cur : new int[]{j - A[i], j + A[i]}) {
                    if (cur < 0 || cur > 20) continue;
                    Dy[i][cur] += Dy[i - 1][j];
                }
            }
        }


        System.out.println(Dy[N -1][A[N]]);
    }


}


