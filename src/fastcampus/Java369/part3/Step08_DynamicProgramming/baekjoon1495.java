
package fastcampus.Java369.part3.Step08_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon1495 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] Dy = new boolean[N + 1][M + 1];

        int[] A = new int[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Dy[0][S] = true;

        int result = 0;

        for (int i = 1; i <= N; i++) {
            boolean flag = false;
            result = 0;
            for (int j = 0; j <= M; j++) {
                if (!Dy[i - 1][j]) continue;
                for (int cur : new int[]{j - A[i], j + A[i]}) {
                    if (cur < 0 || cur > M) continue;
                    Dy[i][cur] = true;
                    result = Math.max(result, cur);
                    flag = true;
                }
            }
            if (!flag) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(result);

    }
    
}


