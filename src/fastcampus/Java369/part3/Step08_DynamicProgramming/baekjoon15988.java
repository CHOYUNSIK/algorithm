
package fastcampus.Java369.part3.Step08_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon15988 {


    static int N;
    static int[] Dy;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        pro();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            System.out.println(Dy[N]);
        }


    }

    private static void pro() {
        Dy = new int[1000005];

        Dy[1] = 1;
        Dy[2] = 2;
        Dy[3] = 4;

        for (int i = 4; i <= 1000000; i++) {
            Dy[i] = Dy[i - 1];
            Dy[i] += Dy[i - 2];
            Dy[i] %= 1000000009;
            Dy[i] += Dy[i - 3];
            Dy[i] %= 1000000009;
        }
    }


}

