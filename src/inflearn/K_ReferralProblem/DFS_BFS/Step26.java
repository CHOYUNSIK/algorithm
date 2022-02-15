package inflearn.K_ReferralProblem.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Step26 {

    static int n, m;
    static int[][] map;
    static boolean[][][] visit;
    static Node start, end;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static class Node {
        int x;
        int y;
        int direction;

        int command;

        public Node(int x, int y, int direction, int command) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.command = command;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 1][m + 1];
        visit = new boolean[n + 1][m + 1][5];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        start = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
        st = new StringTokenizer(br.readLine(), " ");
        end = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

        bfs();

    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        visit[start.x][start.y][start.direction] = true;
        q.offer(start);

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int curX = cur.x;
            int curY = cur.y;
            int curDirection = cur.direction;
            int curCommand = cur.command;

            if (curX == end.x && curY == end.y && curDirection == end.direction) {
                System.out.println(curCommand);
                return;
            }

            for (int i = 1; i <= 3; i++) {
                int nx = curX + (dx[curDirection - 1] * i);
                int ny = curY + (dy[curDirection - 1] * i);

                if (nx <= 0 || ny <= 0 || nx > n || ny > m) continue;

                if (map[nx][ny] == 0) {
                    if (!visit[nx][ny][curDirection]) {
                        visit[nx][ny][curDirection] = true;
                        q.offer(new Node(nx, ny, curDirection, curCommand + 1));
                    }
                } else {
                    break;
                }
            }


            for (int i = 1; i <= 4; i++) {
                if (curDirection != i && !visit[curX][curY][i]) {
                    int turn = 1;
                    if (curDirection == 1) {
                        if (i == 2) {
                            turn++;
                        }
                    } else if (curDirection == 2) {
                        if (i == 1) {
                            turn++;
                        }
                    } else if (curDirection == 3) {
                        if (i == 4) {
                            turn++;
                        }
                    } else {
                        if (i == 3) {
                            turn++;
                        }
                    }
                    visit[curX][curY][i] = true;
                    q.offer(new Node(curX, curY, i, curCommand + turn));
                }
            }


        }
    }


}
