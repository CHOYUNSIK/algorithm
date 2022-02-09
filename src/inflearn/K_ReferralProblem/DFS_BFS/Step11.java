package inflearn.K_ReferralProblem.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Step11 {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[][] direct = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int mh = Integer.MIN_VALUE;
    static int result = Integer.MIN_VALUE;
    static Queue<int[]> q = new LinkedList<>();
    static boolean flag = false;

    static int dfs(int x, int y, int k) {
        visited[x][y] = true;
        for (int i = 0; i < direct.length; i++) {
            int nx = x + direct[i][0];
            int ny = y + direct[i][1];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                continue;
            }
            if (!visited[nx][ny] && map[nx][ny] > k) {
                dfs(nx, ny, k);
            }
        }
        return 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];



        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                mh = Math.max(mh, map[i][j]);
            }
        }

        for (int k = 0; k <= mh; k++) {
            visited = new boolean[n][n];
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && map[i][j] > k) {

                       cnt += dfs(i, j, k);
                    }

                    /*if (map[i][j] <= k ) {
                        flag = true;
                    }else {
                        q.add(new int[]{i, j});
                    }*/
                }
            }

            result = Math.max(result,cnt);
            /*if(!flag){
                result = 1;
            }
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int x = cur[0];
            }*/
        }
        System.out.println(result);
    }
}
