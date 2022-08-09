
package fastcampus.Java369.part3.GraphAndSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon2178 {

    static int N, M;
    static char[][] graph;
    static boolean[][] visited;
    static int[][] dist;
    static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new char[N][M];

        for (int i = 0; i < N; i++) {
            graph[i] = br.readLine().toCharArray();
        }

        visited = new boolean[N][M];
        dist = new int[N][M];


        bfs2178(0, 0);

        System.out.println(dist[N - 1][M - 1]);

    }

    private static void bfs2178(int x, int y) {

        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], -1);
        }

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{x, y});
        visited[x][y] = true;
        dist[x][y] = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < move.length; i++) {
                int nx = cur[0] + move[i][0];
                int ny = cur[1] + move[i][1];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (visited[nx][ny]) continue;
                if (graph[nx][ny] == '0') continue;

                queue.add(new int[]{nx, ny});
                visited[nx][ny] = true;
                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
            }

        }

    }
}
