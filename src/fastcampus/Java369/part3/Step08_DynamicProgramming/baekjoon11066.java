
package fastcampus.Java369.part3.Step08_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon11066 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine());
            int[][] sum = new int[K + 1][K + 1];
            int[] num = new int[K + 1];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 1; i <= K; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= K; i++) {
                for (int j = i; j <= K; j++) {
                    sum[i][j] = sum[i][j - 1] + num[j];
                }
            }

            int[][] Dy = new int[K + 1][K + 1];

            for (int len = 2; len <= K; len++) {
                for (int i = 1; i <= K - len + 1; i++) {
                    int j = i + len - 1;

                    Dy[i][j] = Integer.MAX_VALUE;

                    for (int k = i; k < j; k++) {
                        Dy[i][j] = Math.min(Dy[i][j], Dy[i][k] + Dy[k + 1][j] + sum[i][j]);
                    }

                }
            }

            System.out.println(Dy[1][K]);

        }


    }


}

