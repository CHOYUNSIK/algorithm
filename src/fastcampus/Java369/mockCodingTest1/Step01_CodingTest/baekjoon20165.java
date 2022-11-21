package fastcampus.Java369.mockCodingTest1.Step01_CodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon20165 {

    static int N, M, R, result;
    static int[][] arr, backup;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][M + 1];
        backup = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                backup[i][j] = arr[i][j];
            }
        }

        for (int i = 1; i <= R; i++) {

            st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            String d = st.nextToken();

            attack(x, y, d);


            st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            arr[x][y] = backup[x][y];

        }

        System.out.println(result);

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (arr[i][j] == 0) {
                    System.out.print("F ");
                } else {
                    System.out.print("S ");
                }
            }
            System.out.println();
        }

    }

    private static void attack(int x, int y, String d) {
        if (arr[x][y] == 0) return;


        int dx = 0, dy = 0;

        switch (d) {
            case "E":
                dy = 1;
                break;
            case "W":
                dy = -1;
                break;
            case "S":
                dx = 1;
                break;
            case "N":
                dx = -1;
                break;
        }

        int cnt = arr[x][y];
        while (x >= 1 && x <= N && y >= 1 && y <= M && cnt >= 1) {
            if (arr[x][y] != 0) result++;

            cnt = Math.max(cnt - 1, arr[x][y] - 1);

            arr[x][y] = 0;

            x += dx;
            y += dy;
        }

    }

}
