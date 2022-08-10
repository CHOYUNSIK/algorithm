
package fastcampus.Java369.part3.GraphAndSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon18404 {

    static int N, M, X, Y;
    static int[][] target, graph, dist;
    static boolean[][] visit;

    static int[][] move = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];
        dist = new int[N + 1][N + 1];
        visit = new boolean[N + 1][N + 1];


        target = new int[M][2];

        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine(), " ");

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            target[i] = new int[]{A, B};
        }

        dfs18404();

        for (int i = 0; i < M; i++) {
            System.out.print(dist[target[i][0]][target[i][1]] + " ");
        }

    }

    private static void dfs18404() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{X, Y});
        visit[X][Y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < move.length; i++) {
                int nx = cur[0] + move[i][0];
                int ny = cur[1] + move[i][1];

                if (nx < 0 || ny < 0 || nx > N || ny > N) continue;
                if (visit[nx][ny]) continue;

                queue.add(new int[]{nx, ny});
                visit[nx][ny] = true;
                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;

            }

        }

    }


}
