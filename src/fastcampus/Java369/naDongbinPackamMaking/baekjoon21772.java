package fastcampus.Java369.naDongbinPackamMaking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon21772 {


    static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static char[][] arr;
    static boolean[][] visited;

    static int T, R, C, result = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        visited = new boolean[R][C];

        int sx = 0, sy = 0;

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] == 'G') {
                    sx = i;
                    sy = j;
                }
            }
        }

        dfs(sx, sy, 0, 0);

        System.out.println(result);
    }

    private static void dfs(int sx, int sy, int eating, int count) {
        if (count == T) {
            result = Math.max(result, eating);
            return;
        }
        visited[sx][sy] = true;
        for (int i = 0; i < 4; i++) {
            int nx = sx + move[i][0];
            int ny = sy + move[i][1];

            if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;

            if (arr[nx][ny] == '#') continue;

            if (visited[nx][ny]) {
                dfs(nx, ny, eating, count + 1);
            } else {
                if (arr[nx][ny] == 'S') {
                    dfs(nx, ny, eating + 1, count + 1);
                    visited[nx][ny] = false;
                } else {
                    dfs(nx, ny, eating, count + 1);
                }

            }

        }

    }


}
