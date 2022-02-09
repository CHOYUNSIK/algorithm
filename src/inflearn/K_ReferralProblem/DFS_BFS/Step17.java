package inflearn.K_ReferralProblem.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Step17 {

    static class Boll {
        int rx;
        int ry;
        int bx;
        int by;

        int cnt;

        public Boll(int rx, int ry, int bx, int by, int cnt) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char map[][] = new char[n][m];
        boolean[][][][] visited = new boolean[n][m][n][m];
        int rx = 0, ry = 0, bx = 0, by = 0;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            map[i] = str.toCharArray();
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'R') {
                    rx = i;
                    ry = j;
                }
                if (map[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }
        Queue<Boll> q = new LinkedList<>();
        Boll boll = new Boll(rx, ry, bx, by, 0);
        visited[rx][ry][bx][by] = true;
        q.offer(boll);

        int min = Integer.MAX_VALUE;

        int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        while (!q.isEmpty()) {
            Boll poll = q.poll();
            if (map[poll.bx][poll.by] == 'O') continue;

            if (map[poll.rx][poll.ry] == 'O' && map[poll.bx][poll.by] != 'O') {
                min = Math.min(min, poll.cnt);
            }

            for (int i = 0; i < 4; i++) {
                int crx = poll.rx, cry = poll.ry, cbx = poll.bx, cby = poll.by;

                while (map[crx+move[i][0]][cry+move[i][1]] != '#') {
                    crx += move[i][0];
                    cry += move[i][1];
                    if (map[crx][cry] == 'O') break;
                }

                while (map[cbx+move[i][0]][cby+move[i][1]] != '#') {
                    cbx += move[i][0];
                    cby += move[i][1];
                    if (map[cbx][cby] == 'O') break;
                }

                if (cry == cby && crx == cbx && map[crx][cry] != 'O') {
                    int rm = Math.abs(crx - poll.rx) + Math.abs(cry - poll.ry);
                    int bm = Math.abs(cbx - poll.bx) + Math.abs(cby - poll.by);
                    if (rm > bm) {
                        crx -= move[i][0];
                        cry -= move[i][1];
                    } else {
                        cbx -= move[i][0];
                        cby -= move[i][1];
                    }
                }

                if (!visited[crx][cry][cbx][cby]) {
                    visited[crx][cry][cbx][cby] = true;
                    q.offer(new Boll(crx, cry, cbx, cby, poll.cnt + 1));
                }

            }

        }

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }

    }

}
