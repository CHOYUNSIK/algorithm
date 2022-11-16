
package fastcampus.Java369.part3.Step08_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon1509 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int n = str.length();

        char[] arr = str.toCharArray();
        boolean[][] check = new boolean[n + 1][n + 1];
        int[] dy = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dy[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= n; i++) {
            check[i][i] = true;
        }

        for (int i = 1; i <= n - 1; i++) {
            if (arr[i - 1] == arr[i]) check[i][i + 1] = true;
        }

        for (int i = 2; i < n; i++) {
            for (int j = 1; j <= n - i; j++) {
                if (arr[j - 1] == arr[j + i - 1] && check[j + 1][j + i - 1]) check[j][j + i] = true;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (check[j][i]) {
                    dy[i] = Math.min(dy[i], dy[j - 1] + 1);
                }
            }
        }

        System.out.println(dy[n]);

    }

}

