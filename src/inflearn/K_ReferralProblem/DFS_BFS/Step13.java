package inflearn.K_ReferralProblem.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Step13 {
    static char[][] map;
    static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    static class Marble {
        int x;
        int y;

        public Marble(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        boolean[][][][] visited = new boolean[n][m][n][m];

        Marble marbleR = null; //빨강
        Marble marbleB = null; //파랑

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'R') {
                    marbleR = new Marble(i, j);
                } else if (map[i][j] == 'B') {
                    marbleB = new Marble(i, j);
                }
            }
        }
       /* for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }*/
        Queue<Marble[]> q = new LinkedList<>();
        q.offer(new Marble[]{marbleR, marbleB});
        visited[marbleR.x][marbleR.y][marbleB.x][marbleB.y] = true;

        int count = 0;
        while (!q.isEmpty() && count++ < 10) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Marble[] marbles = q.poll();
                for (int j = 0; j < 4; j++) {
                    Marble r = new Marble(marbles[0].x, marbles[0].y);
                    Marble b = new Marble(marbles[1].x, marbles[1].y);
                    /*Marble r = marbles[0];
                    Marble b = marbles[1];*/
                    boolean redFirst = redFirstCheck(r, b, j);
                    move(r, j);
                    move(b, j);

                    if (map[b.x][b.y] == 'O') continue;
                    if (r.x == b.x && r.y == b.y) marbleBack(r, b, redFirst, j);
                    if (map[r.x][r.y] == 'O') {
                        System.out.println(1);
                        System.exit(0);
                    }

                    if (visited[r.x][r.y][b.x][b.y]) continue;
                    visited[r.x][r.y][b.x][b.y] = true;

                    q.offer(new Marble[]{r, b});

                }
            }
        }
        System.out.println(0);
    }

    static void marbleBack(Marble r, Marble b, Boolean redFirst, int n) {
        switch (n) {
            case 0:
                if (redFirst) b.x++;
                else r.x++;
                break;
            case 1:
                if (redFirst) b.y--;
                else r.y--;
                break;
            case 2:
                if (redFirst) b.x--;
                else r.x--;
                break;
            case 3:
                if (redFirst) b.y++;
                else r.y++;
                break;
        }
    }

    static void move(Marble m, int n) {
        while (true) {
            int nx = m.x + move[n][0];
            int ny = m.y + move[n][1];

            if (map[nx][ny] == '#') break;
            m.x = nx;
            m.y = ny;
            if (map[nx][ny] == 'O') break;
        }
    }

    static boolean redFirstCheck(Marble r, Marble b, int n) {
        switch (n) {
            case 0:
                return r.x < b.x;
            case 1:
                return r.y > b.y;
            case 2:
                return r.x > b.x;
            case 3:
                return r.y < b.y;
            default:
                return false;
        }
    }
}
