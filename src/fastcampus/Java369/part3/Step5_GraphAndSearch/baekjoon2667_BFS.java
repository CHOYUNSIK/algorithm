
package fastcampus.Java369.part3.Step5_GraphAndSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class baekjoon2667_BFS {

    static int N, count;
    static int[][] graph;
    static boolean[][] visited;

    static ArrayList<Integer> result = new ArrayList<>();

    static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            char[] charArr = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(String.valueOf(charArr[j]));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] || graph[i][j] == 0) continue;
                count = 0;
                bfs2667(i, j);
                result.add(count);
            }
        }

        Collections.sort(result);

        System.out.println(result.size());

        for (int x : result) {
            System.out.println(x);
        }


    }

    private static void bfs2667(int x, int y) {

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{x, y});
        visited[x][y] = true;
        count++;

        while (!que.isEmpty()) {

            int[] cur = que.poll();

            int curX = cur[0];
            int curY = cur[1];

            for (int i = 0; i < move.length; i++) {

                int nextX = curX + move[i][0];
                int nextY = curY + move[i][1];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
                if (visited[nextX][nextY]) continue;

                if (graph[nextX][nextY] == 1) {
                    que.add(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                    count++;
                }

            }

        }


    }

}