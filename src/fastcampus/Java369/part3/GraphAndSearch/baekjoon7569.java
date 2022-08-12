

package fastcampus.Java369.part3.GraphAndSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon7569 {


    static int M, N, H;
    static int[][][] graph;
    static int[][] move = {{1, 0, 0}, {-1, 0, 0}, {0, -1, 0}, {0, 0, 1}, {0, 1, 0}, {0, 0, -1}};
    static int[][][] disk;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());


        disk = new int[H + 1][N + 1][M + 1];

        graph = new int[H + 1][N + 1][M + 1];

        for (int h = 1; h <= H; h++) {
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 1; j <= M; j++) {
                    graph[h][i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        dfs7569();


        int result = 0;
        for (int h = 1; h <= H; h++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (graph[h][i][j] == -1) continue;
                    if (disk[h][i][j] == -1) {
                        System.out.println(-1);
                        return;
                    }
                    result = Math.max(result, disk[h][i][j]);
                }
            }
        }

        System.out.println(result);

    }

    private static void dfs7569() {

        Queue<int[]> queue = new LinkedList<>();

        for (int h = 1; h <= H; h++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    disk[h][i][j] = -1;
                    if (graph[h][i][j] == 1) {
                        queue.add(new int[]{h, i, j});
                        disk[h][i][j] = 0;
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < move.length; i++) {
                int nh = cur[0] + move[i][0];
                int nx = cur[1] + move[i][1];
                int ny = cur[2] + move[i][2];

                if (nh < 1 || nx < 1 || ny < 1 || nh > H || nx > N || ny > M) continue;
                if (graph[nh][nx][ny] == -1) continue;
                if (disk[nh][nx][ny] != -1) continue;

                queue.add(new int[]{nh, nx, ny});
                disk[nh][nx][ny] = disk[cur[0]][cur[1]][cur[2]] + 1;

            }


        }


    }
}
