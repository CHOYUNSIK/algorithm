package fastcampus.Java369.mockCodingTest.Step03_CodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon22251 {

    static int N, K, P, X;


    static int[][] num_flag = {
            {1, 1, 1, 0, 1, 1, 1},
            {0, 0, 1, 0, 0, 1, 0},
            {1, 0, 1, 1, 1, 0, 1},
            {1, 0, 1, 1, 0, 1, 1},
            {0, 1, 1, 1, 0, 1, 0},
            {1, 1, 0, 1, 0, 1, 1},
            {1, 1, 0, 1, 1, 1, 1},
            {1, 0, 1, 0, 0, 1, 0},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 0, 1, 1},
    };


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // 층
        K = Integer.parseInt(st.nextToken()); // 디스플레이 자리수
        P = Integer.parseInt(st.nextToken()); // LED 반전 개수
        X = Integer.parseInt(st.nextToken()); // 현재 층수



        int result = 0;
        for (int i = 1; i <= N; i++) {
            if (X == i) continue;
            int num = confirmation(i, X);
            if (P >= num) result++;
        }

        System.out.println(result);

    }

    private static int confirmation(int x, int y) {

        int n = 0;

        for (int i = 1; i <= K; i++) {
            n += check(x % 10, y % 10);
            x /= 10;
            y /= 10;
        }

        return n;
    }

    private static int check(int x, int y) {

        int n = 0;

        for (int i = 0; i < 7; i++){
            n += num_flag[x][i] != num_flag[y][i] ? 1 : 0;
        }

        return n;
    }
}

