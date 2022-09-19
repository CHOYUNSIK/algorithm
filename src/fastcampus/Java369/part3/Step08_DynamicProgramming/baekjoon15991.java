
package fastcampus.Java369.part3.Step08_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon15991 {


    static int[] Dy;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        pro();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
           int x = Integer.parseInt(br.readLine());

            int res = 0;
            for (int mid = 1; mid <= 3; mid++)
                if (x - mid >= 0 && (x - mid) % 2 == 0) {
                    res += Dy[(x - mid) / 2];
                    res %= 1000000009;
                }

            if (x % 2 == 0) {
                res += Dy[x / 2];
                res %= 1000000009;
            }

            System.out.println(res);
        }


    }

    private static void pro() {
        Dy = new int[100005];

        Dy[0] = 1;

        for (int i = 1; i <= 100000; i++) {
            Dy[i] = Dy[i - 1];
            if (i - 2 >= 0) Dy[i] += Dy[i - 2];
            Dy[i] %= 1000000009;
            if (i - 3 >= 0) Dy[i] += Dy[i - 3];
            Dy[i] %= 1000000009;
        }
    }


}

