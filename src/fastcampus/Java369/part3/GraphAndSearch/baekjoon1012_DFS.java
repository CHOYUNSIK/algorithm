
package fastcampus.Java369.part3.GraphAndSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon1012_DFS {

    static int T, N, M, K ,count;
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

                    if (graph[x][y] == 1 && !visited[x][y]){
                        count++;
                        dfs1012(x, y);
                    }


                }
            }

            System.out.println(count);

        }


    }

    private static void dfs1012(int x, int y) {

        visited[x][y] = true;

        for (int i = 0; i < move.length; i++) {

            int nextX = x + move[i][0];
            int nextY = y + move[i][1];

            if (nextX < 0 || nextY < 0 || nextY >= M || nextX >= N) continue;
            if (visited[nextX][nextY]) continue;

            if(graph[nextX][nextY] == 1){
                dfs1012(nextX, nextY);
            }


        }

    }


}