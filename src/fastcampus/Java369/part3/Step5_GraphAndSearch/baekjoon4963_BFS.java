
package fastcampus.Java369.part3.Step5_GraphAndSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon4963_BFS {

    static int w, h, count;
    static int[][] graph;
    static boolean[][] visited;

    static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) break;

            graph = new int[h][w];
            count = 0;

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                for (int j = 0; j < w; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {

                for (int j = 0; j < w; j++) {
                    if (graph[i][j] == 0 || visited[i][j]) continue;

                    bfs4963(i, j);
                    count++;

                }

            }

            System.out.println(count);
        }

    }

    private static void bfs4963(int x, int y) {

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < move.length; i++) {

                int nx = cx + move[i][0];
                int ny = cy + move[i][1];

                if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
                if (visited[nx][ny]) continue;
                if (graph[nx][ny] == 0) continue;

                queue.offer(new int[]{nx, ny});
                visited[nx][ny] = true;

            }

        }


    }
}