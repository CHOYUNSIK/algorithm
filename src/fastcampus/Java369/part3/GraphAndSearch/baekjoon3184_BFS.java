
package fastcampus.Java369.part3.GraphAndSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon3184_BFS {

    static int r, c, v, o;
    static int rv = 0, ro = 0;
    static char[][] graph;
    static boolean[][] visited;

    static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        graph = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            graph[i] = str.toCharArray();
        }


        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (visited[i][j]) continue;
                if (graph[i][j] == 'v' || graph[i][j] == 'o') {
                    if (graph[i][j] == 'v') {
                        v = 1;
                        o = 0;
                    } else {
                        o = 1;
                        v = 0;
                    }
                    bfs3184(i, j);
                    if (v >= o) {
                        rv += v;
                    } else {
                        ro += o;
                    }
                }
            }
        }

        System.out.println(ro + " " + rv);

    }

    private static void bfs3184(int x, int y) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < move.length; i++) {
                int nx = cur[0] + move[i][0];
                int ny = cur[1] + move[i][1];

                if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
                if (visited[nx][ny]) continue;
                if (graph[nx][ny] == '#') continue;
                queue.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
                if (graph[nx][ny] == 'v') v++;
                if (graph[nx][ny] == 'o') o++;
            }
        }

    }

}