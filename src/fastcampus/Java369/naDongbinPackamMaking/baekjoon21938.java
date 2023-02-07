package fastcampus.Java369.naDongbinPackamMaking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon21938 {

    static int N, M;

    static int[][] arr;
    static boolean[][] visited;

    static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < M; j++) {

                int r = Integer.parseInt(st.nextToken());
                int g = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                int sum = (r + g + b) / 3;

                arr[i][j] = sum;
            }

        }

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] >= T) {
                    arr[i][j] = 255;
                } else {
                    arr[i][j] = 0;
                }
            }
        }

        int result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] || arr[i][j] != 255) continue;
                result++;
                dfs(i, j);
            }
        }

        System.out.println(result);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < move.length; i++) {
            int nx = x + move[i][0];
            int ny = y + move[i][1];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if (visited[nx][ny] || arr[nx][ny] != 255) continue;

            dfs(nx, ny);
        }

    }


}
