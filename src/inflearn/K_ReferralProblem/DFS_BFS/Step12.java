package inflearn.K_ReferralProblem.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Step12 {
    static Point start, end;
    static int[] dl = {0, 0, 0, 0, 1, -1};
    static int[] dr = {-1, 0, 1, 0, 0, 0};
    static int[] dc = {0, 1, 0, -1, 0, 0};

    /*static int l,r,c;*/
    /*static char[][][] map;*/
    /*static int[][][] arr;*/
    /*static boolean[][][] visited;*/
    static class Point {
        int l;
        int r;
        int c;
        int count;

        public Point(int l, int r, int c, int count) {
            this.l = l;
            this.r = r;
            this.c = c;
            this.count = count;
        }

    }

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (l == 0 && r == 0 && c == 0) break;

           char[][][] map = new char[l][r][c];
            /*arr = new int[l][r][c];*/
            boolean[][][] visited = new boolean[l][r][c];

            for (int f = 0; f < l; f++) {
                for (int i = 0; i < r; i++) {
                    String str = br.readLine();
                    for (int j = 0; j < c; j++) {
                        map[f][i][j] = str.charAt(j);
                        if (map[f][i][j] == 'S') {
                            start = new Point(f, i, j, 0);
                        }
                        if (map[f][i][j] == 'E') {
                            end = new Point(f, i, j, 0);
                        }
                    }
                }
                br.readLine();
            }
            Queue<Point> q = new LinkedList<>();
            q.offer(start);
            boolean flag = false;
            /*int count = 0;*/
            while (!q.isEmpty()) {
                Point p = q.poll();
                int lp = p.l;
                int lr = p.r;
                int lc = p.c;
                int count = p.count;
                if (lp == end.l && lr == end.r && lc == end.c) {
                    System.out.println("Escaped in " + count + " minute(s)");
                    q.clear();
                    flag = true;
                    break;
                }
                visited[lp][lr][lc] = true;
                for (int i = 0; i < 6; i++) {
                    int nl = lp + dl[i];
                    int nr = lr + dr[i];
                    int nc = lc + dc[i];

                    if(nl >= 0 && nl < l && nr >= 0 && nr < r && nc >= 0 && nc < c) {
                        if(visited[nl][nr][nc] == false && map[nl][nr][nc] != '#') {
                            /*visited[nl][nr][nc] = true;*/
                            q.offer(new Point(nl, nr, nc, count + 1));
                        }
                    }

                    /*if (nl < 0 || nr < 0 || nc < 0 || nl >= l || nr >= r || nc >= c) continue;*/
                    /*if (visited[nl][nr][nc] || map[nl][nr][nc] == '#') continue;*/
                    /*arr[nl][nr][nc] = arr[lp][lr][lc] + 1;*/
                    /*count++;*/
                    /*q.offer(new Point(nl, nr, nc, count + 1));*/
                }
            }
            if (!flag) {
                System.out.println("Trapped!");
            }

        }
    }
}
