
package fastcampus.Java369.part3.GraphAndSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon1012_BFS {

    static int T, N, M, K, count;
    static int[][] graph;
    static boolean[][] visited;

    static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            graph = new int[N][M];
            visited = new boolean[N][M];
            count = 0;

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int m = Integer.parseInt(st.nextToken());
                int n = Integer.parseInt(st.nextToken());
                graph[n][m] = 1;
            }

            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {

                    if (graph[x][y] == 1 && !visited[x][y]) {
                        count++;
                        bfs1012(x, y);
                    }


                }
            }

            System.out.println(count);

        }


    }

    private static void bfs1012(int x, int y) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int i = 0; i < move.length; i++) {
                int nx = curX + move[i][0];
                int ny = curY + move[i][1];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (visited[nx][ny]) continue;
                if (graph[nx][ny] == 0) continue;

                queue.add(new int[]{nx, ny});
                visited[nx][ny] = true;

            }

        }


    }


}