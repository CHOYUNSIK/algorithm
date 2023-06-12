package fastcampus.Java369.naDongbinPackamMaking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon21922 {

    static int N, M;
    static int[][] arr;

    static final int dy[] = {-1,1,0,0};
    static final int dx[] = {0,0,-1,1};
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Queue<int[]> queue = new LinkedList<>();

        arr = new int[N][M];
        visited = new boolean[N][M][5];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 9) {
                    queue.add(new int[]{j, i});
                }
            }
        }

        int result = 0;

        while (queue.isEmpty() == false) {

            int[] cur = queue.poll();

            int x = cur[0];
            int y = cur[1];

            if (!visited[y][x][4]) {
                visited[y][x][4] = true;
                result++;
            }

            for (int i = 0; i < 4; i++) {

                int dir = i;
                int cx = x;
                int cy = y;

                if (visited[cy][cx][dir]) continue;
                visited[cy][cx][dir] = true;

                while (true) {
                    cx += dx[dir];
                    cy += dy[dir];

                    if(0 > cy || cy >= N || 0 > cx || cx >= M) break;
                    if (visited[cy][cx][dir]) break;

                    visited[cy][cx][dir] = true;

                    if (!visited[cy][cx][4]) {
                        visited[cy][cx][4] = true;
                        result++;
                    }

                    dir = changDir(arr[cy][cx], dir);


                }

            }

        }
        System.out.println(result);

    }

    private static int changDir(int type, int dir) {
        if (type == 1) {
            if (dir == 2) return 3;
            if (dir == 3) return 2;
        }
        if (type == 2) {
            if (dir == 0) return 1;
            if (dir == 1) return 0;
        }
        if (type == 3) {
            if (dir == 0) return 3;
            if (dir == 1) return 2;
            if (dir == 2) return 1;
            if (dir == 3) return 0;
        }
        if (type == 4) {
            if (dir == 0) return 2;
            if (dir == 1) return 3;
            if (dir == 2) return 0;
            if (dir == 3) return 1;
        }
        return dir;
    }


}
