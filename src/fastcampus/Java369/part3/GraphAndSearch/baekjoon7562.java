
package fastcampus.Java369.part3.GraphAndSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon7562 {

    static int T, I, X, Y, RX, RY;
    static boolean[][] visited;
    static int[][] dist, graph;

    static int[][] move = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            I = Integer.parseInt(br.readLine());
            graph = new int[I][I];
            visited = new boolean[I][I];
            dist = new int[I][I];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");

            RX = Integer.parseInt(st.nextToken());
            RY = Integer.parseInt(st.nextToken());

            bfs7562(X, Y);
            System.out.println(dist[RX][RY]);
        }


    }

    private static void bfs7562(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        dist[x][y] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < move.length; i++) {
                int nx = cur[0] + move[i][0];
                int ny = cur[1] + move[i][1];

                if (nx < 0 || ny < 0 || nx >= I || ny >= I) continue;
                if (visited[nx][ny]) continue;

                queue.add(new int[]{nx, ny});
                visited[nx][ny] = true;
                dist[nx][ny] = dist[cur[0]][cur[1]] + 1 ;
            }


        }

    }


}
