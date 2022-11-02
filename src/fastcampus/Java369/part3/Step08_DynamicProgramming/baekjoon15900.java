
package fastcampus.Java369.part3.Step08_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon15900 {

    public static void main(String[] args) throws IOException {

        int MOD = 1000000009;

        int[][] Dy = new int[100005][4];

        Dy[1][1] = 1;
        Dy[2][2] = 1;
        Dy[3][1] = 1;
        Dy[3][2] = 1;
        Dy[3][3] = 1;


        for (int i = 4; i <= 100000; i++) {
            for (int cur = 1; cur <= 3; cur++) {
                for (int prev = 1; prev <= 3; prev++){
                    if (cur == prev) continue;
                    Dy[i][cur] += Dy[i - cur][prev];
                    Dy[i][cur] %= MOD;
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int result = 0;

            for (int i = 1; i <= 3; i++){
                result += Dy[N][i];
                result %= MOD;
            }
            System.out.println(result);
        }
    }
}

 