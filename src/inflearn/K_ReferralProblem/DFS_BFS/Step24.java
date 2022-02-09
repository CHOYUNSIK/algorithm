package inflearn.K_ReferralProblem.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Step24 {

    static int r, c, res = -1;
    static char[][] map;
    static boolean[][] sVisited;
    static boolean[][] wVisited;

    static Queue<Node> sq = new LinkedList<>();
    static Queue<Node> wq = new LinkedList<>();

    static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};


    static class Node {
        int x;
        int y;
        int move;

        public Node(int x, int y, int move) {
            this.x = x;
            this.y = y;
            this.move = move;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        sVisited = new boolean[r][c];
        wVisited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'S') {
                    sq.offer(new Node(i, j, 0));
                }
                if (map[i][j] == '*') {
                    wq.offer(new Node(i, j, 0));
                }
            }
        }
        bfs();
        System.out.println(res == -1 ? "KAKTUS" : res);
    }

    static void bfs() {
        while (true) {
            waterMove();

            int size = sq.size();

            if (size == 0) break;

            for (int i = 0; i < size; i++) {
                Node s = sq.poll();
                int num = s.move;
                for (int j = 0; j < 4; j++) {
                    int nx = s.x + move[j][0];
                    int ny = s.y + move[j][1];
                     if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                     if (sVisited[nx][ny]) continue;

                     if(map[nx][ny] == 'D') {
                         res = num+1;
                         return;
                     }
                     if(map[nx][ny] == '.' && !wVisited[nx][ny]) {
                         sVisited[nx][ny] = true;
                         sq.offer(new Node(nx, ny, num+1));
                     }
                 }
            }

        }

    }

    static void waterMove() {
        int size = wq.size();

        for (int i = 0; i < size; i++) {
            Node water = wq.poll();
            for (int j = 0; j < 4; j++) {
                int nx = water.x + move[j][0];
                int ny = water.y + move[j][1];

                if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                if (wVisited[nx][ny]) continue;
                if (map[nx][ny] == '.') {
                    wVisited[nx][ny] = true;
                    wq.offer(new Node(nx, ny, 0));
                }
            }
        }
    }

}
