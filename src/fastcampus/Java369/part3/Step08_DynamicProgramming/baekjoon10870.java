
package fastcampus.Java369.part3.Step08_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon10870 {


    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        pro();

    }

    private static void pro() {
        int[] Dy = new int[25];

        Dy[0] = 0;
        Dy[1] = 1;
        Dy[2] = 1;
        Dy[3] = 2;

        for (int i = 4; i <= N; i++) {
            Dy[i] = Dy[i - 1] + Dy[i - 2];
        }

        System.out.println(Dy[N]);
    }


}

