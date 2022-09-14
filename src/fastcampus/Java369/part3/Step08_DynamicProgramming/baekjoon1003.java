
package fastcampus.Java369.part3.Step08_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon1003 {
    static long[][] Dy;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        pro();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            int N = Integer.parseInt(br.readLine());

            System.out.println(Dy[N][0] + " " + Dy[N][1]);

        }

    }

    private static void pro() {
        Dy = new long[40 + 1][2];

        Dy[0][0] = 1;
        Dy[1][1] = 1;

        for (int i = 2; i <= 40; i++) {
            Dy[i][0] = Dy[i - 1][0] + Dy[i - 2][0];
            Dy[i][1] = Dy[i - 1][1] + Dy[i - 2][1];
        }
    }


}

