
package fastcampus.Java369.part3.Step08_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon2011 {


    static int N, M = 1000000;
    static long[] Dy;
    static String str;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();
        N = str.length();

        Dy = new long[N];

        if (N == 0 || str.charAt(0) == '0') {
            System.out.println(0);
            return;
        }

        Dy[0] = 1;
        for (int i = 1; i < N; i++) {
            if (str.charAt(i) != '0') Dy[i] = Dy[i - 1];

            if (check(str.charAt(i - 1), str.charAt(i))) {
                if (i >= 2) Dy[i] += Dy[i - 2];
                else Dy[i] += 1;
                Dy[i] %= M;
            }
        }

        System.out.println(Dy[N - 1]);
    }

    private static boolean check(char A, char B) {
        if (A == '0') return false;
        if (A == '1') return true;
        if (A >= '3') return false;

        return B <= '6';
    }


}

