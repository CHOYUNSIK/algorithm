package inflearn.K_ReferralProblem.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Step14 {

    static class Marble14 {
        int rx;
        int ry;
        int bx;
        int by;
        int num;

        public Marble14(int rx, int ry, int bx, int by, int num) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.num = num;
        }
    }

    static char[][] map;
    static boolean[][][][] visited;
    /*static int[][] direct;*/
    static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m][n][m];


        Marble14 red = null, blue = null;

        int rx = 0, ry = 0, bx = 0, by = 0;

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'R') {
                    rx = i;
                    ry = j;
                } else if (map[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }


        Queue<Marble14> q = new LinkedList<>();
        q.offer(new Marble14(rx, ry, bx, by, 0));
        visited[rx][ry][bx][by] = true;
        //int cnt = 0;

        while (!q.isEmpty()) {
            //for (int i = 0; i < qLength; i++) {

            Marble14 marble = q.poll();

            if (marble.num > 10) {
                System.out.println(-1);
                System.exit(0);
            }

            if (map[marble.bx][marble.by] == 'O') continue;

            if (map[marble.rx][marble.ry] == 'O' && map[marble.bx][marble.by] != 'O') {
                System.out.println(marble.num);
                System.exit(0);
            }

            for (int j = 0; j < 4; j++) {
                // red가 앞인지 check
                boolean redFront = redFrontCheck(marble, n);
                // 기우리기

                int rnx = marble.rx, rny = marble.ry, bnx = marble.bx, bny = marble.by;

                while (map[rnx + move[j][0]][rny + move[j][1]] != '#') {
                    rnx += move[j][0];
                    rny += move[j][1];
                    if (map[rnx][rny] == 'O') break;
                }

                while (map[bnx + move[j][0]][bny + move[j][1]] != '#') {
                    bnx += move[j][0];
                    bny += move[j][1];
                    if (map[bnx][bny] == 'O') break;
                }

                if (rnx == bnx && rny == bny && map[rnx][rny] != 'O') {
                    int red_dis = Math.abs(rnx - marble.rx) + Math.abs(rny - marble.ry);
                    int blue_dis = Math.abs(bnx - marble.bx) + Math.abs(bny - marble.by);

                    if (red_dis > blue_dis) {
                        rnx -= move[j][0];
                        rny -= move[j][1];
                    } else {
                        bnx -= move[j][0];
                        bny -= move[j][1];
                    }
                }
                ;

                if (!visited[rnx][rny][bnx][bny]) {
                    visited[rnx][rny][bnx][bny] = true;
                    q.offer(new Marble14(rnx, rny, bnx, bny, marble.num + 1));
                }
                //  }
            }
        }
        System.out.println(-1);
    }


    static void marbleBack(Marble14 marble, int n, boolean check) {
        switch (n) {
            case 0:
                if (check) marble.bx++;
                else marble.rx++;
                break;
            case 1:
                if (check) marble.by--;
                else marble.ry--;
                break;
            case 2:
                if (check) marble.bx--;
                else marble.rx--;
                break;
            case 3:
                if (check) marble.by++;
                else marble.ry++;
                break;
        }
    }

/*    static void moving(Marble14 marble, int n) {
        while (true) {
            int nx = marble.x + move[n][0];
            int ny = marble.y + move[n][1];

            if (map[nx][ny] == '#') break;
            marble.x = nx;
            marble.y = ny;
            if (map[nx][ny] == 'O') break;
        }
    }*/


    static boolean redFrontCheck(Marble14 marble, int n) {
        if ((n == 0 && marble.bx > marble.rx) || (n == 1 && marble.by < marble.ry || (n == 2 || marble.bx < marble.rx) || (n == 3 && marble.by > marble.ry))) {
            return true;
        }
        return false;
    }
}
