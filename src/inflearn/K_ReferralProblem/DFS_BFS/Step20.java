package inflearn.K_ReferralProblem.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Step20 {

    static int n, m;

    static int[][] map;

    static int result = Integer.MIN_VALUE;

    static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    static class Virus {
        int x;
        int y;

        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(result);

    }

    static void dfs(int depth) {
        if (depth == 3) {
            int[][] copyMap = new int[n][m];
            copy(copyMap, map);
            bfs();
            copy(map, copyMap);
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(depth + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void copy(int[][] target, int[][] org) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                target[i][j] = org[i][j];
            }
        }
    }

    static void bfs() {
        Queue<Virus> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2) {
                    q.offer(new Virus(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            Virus virus = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = virus.x + move[i][0];
                int ny = virus.y + move[i][1];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (map[nx][ny] == 0) {
                        map[nx][ny] = 1;
                        q.offer(new Virus(nx, ny));
                    }
                }
            }
        }
        count();
    }

    static void count(){

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 0){
                    count++;
                }
            }
        }
        result = Math.max(result, count);
    }
}
