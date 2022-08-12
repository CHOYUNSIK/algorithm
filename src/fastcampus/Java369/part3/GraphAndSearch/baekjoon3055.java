

package fastcampus.Java369.part3.GraphAndSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon3055 {

    static int R, C;
    static boolean[][] visit;
    static String[] graph;
    static int[][] dist_water, dist_hedgehog;

    static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        visit = new boolean[R][C];
        dist_water = new int[R][C];
        dist_hedgehog = new int[R][C];

        graph = new String[R];

        for (int i = 0; i < R; i++) {
            graph[i] = br.readLine();
        }

        dfs3055_water();
        dfs3055_hedgehog();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (graph[i].charAt(j) == 'D') {
                    if (dist_hedgehog[i][j] == -1) System.out.println("KAKTUS");
                    else System.out.println(dist_hedgehog[i][j]);
                }
            }
        }
    }

    private static void dfs3055_hedgehog() {

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                visit[i][j] = false;
                dist_hedgehog[i][j] = -1;

                if (graph[i].charAt(j) == 'S') {
                    queue.add(new int[]{i, j});
                    visit[i][j] = true;
                    dist_hedgehog[i][j] = 0;
                }

            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < move.length; i++) {
                int nx = cur[0] + move[i][0];
                int ny = cur[1] + move[i][1];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (visit[nx][ny]) continue;
                if (graph[nx].charAt(ny) != '.' && graph[nx].charAt(ny) != 'D') continue;
                if (dist_water[nx][ny] != -1 && dist_water[nx][ny] <= dist_hedgehog[cur[0]][cur[1]] + 1) continue;

                queue.add(new int[]{nx, ny});
                visit[nx][ny] = true;
                dist_hedgehog[nx][ny] = dist_hedgehog[cur[0]][cur[1]] + 1;

            }

        }


    }

    private static void dfs3055_water() {

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                visit[i][j] = false;
                dist_water[i][j] = -1;
                if (graph[i].charAt(j) == '*') {
                    queue.add(new int[]{i, j});
                    visit[i][j] = true;
                    dist_water[i][j] = 0;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < move.length; i++) {
                int nx = cur[0] + move[i][0];
                int ny = cur[1] + move[i][1];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (visit[nx][ny]) continue;
                if (graph[nx].charAt(ny) != '.') continue;

                queue.add(new int[]{nx, ny});
                visit[nx][ny] = true;
                dist_water[nx][ny] = dist_water[cur[0]][cur[1]] + 1;
            }

        }

    }
}
