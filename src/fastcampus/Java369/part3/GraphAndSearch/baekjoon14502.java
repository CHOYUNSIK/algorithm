
package fastcampus.Java369.part3.GraphAndSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon14502 {

    static int N, M, B, result;
    static int[][] map, blank;
    static boolean[][] visit;
    static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        blank = new int[N * M + 1][2];
        visit = new boolean[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] == 0) {
                    B++;
                    blank[B][0] = i;
                    blank[B][1] = j;
                }
            }
        }

        dfs14502(1, 0);
        System.out.println(result);
    }

    private static void dfs14502(int idx, int selectIdx) {

        if (selectIdx == 3) {
            bfs14502();
            return;
        }

        if (idx > B) return;

        map[blank[idx][0]][blank[idx][1]] = 1;
        dfs14502(idx + 1, selectIdx + 1);

        map[blank[idx][0]][blank[idx][1]] = 0;
        dfs14502(idx + 1, selectIdx);


    }

    private static void bfs14502() {

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                visit[i][j] = false;
                if (map[i][j] == 2) {
                    queue.add(new int[]{i, j});
                    visit[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int m = 0; m < move.length; m++) {
                int nx = cur[0] + move[m][0];
                int ny = cur[1] + move[m][1];

                if (nx < 1 || ny < 1 || nx > N || ny > M) continue;
                if (visit[nx][ny]) continue;
                if (map[nx][ny] != 0) continue;

                queue.add(new int[]{nx, ny});
                visit[nx][ny] = true;
            }
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] == 0 && !visit[i][j]) {
                    count++;
                }
            }
        }

        result = Math.max(result, count);

    }


}
