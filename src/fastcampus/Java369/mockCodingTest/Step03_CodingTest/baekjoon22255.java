
package fastcampus.Java369.mockCodingTest.Step03_CodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baekjoon22255 {


    static int N, M, SX, SY, EX, EY;
    static int[][] a;
    static int[][][] dy;

    static int dir[][][] = {
            {{1, 0}, {-1, 0}},
            {{0, 1}, {0, -1}},
            {{1, 0}, {-1, 0}, {0, -1}, {0, 1}}
    };

    static class Info {
        int x, y, move, dist;

        public Info(int x, int y, int move, int dist) {
            this.x = x;
            this.y = y;
            this.move = move;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        SX = Integer.parseInt(st.nextToken());
        SY = Integer.parseInt(st.nextToken());
        EX = Integer.parseInt(st.nextToken());
        EY = Integer.parseInt(st.nextToken());

        a = new int[N + 2][M + 2];
        dy = new int[N + 2][M + 2][3];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= M; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                for (int k = 0; k < 3; k++) {

                    dy[i][j][k] = Integer.MAX_VALUE;

                }
            }
        }

        dy[SX][SY][0] = 0;

        PriorityQueue<Info> queue = new PriorityQueue<>(Comparator.comparing(info -> info.dist));

        queue.add(new Info(SX, SY, 0, 0));


        while (!queue.isEmpty()) {

            Info poll = queue.poll();

            int x = poll.x, y = poll.y, move = poll.move, dist = poll.dist;

            if (dist != dy[x][y][move]) continue;

            int choice = move == 2 ? 4 : 2;

            for (int k = 0; k < choice; k++) {

                int nx = x + dir[move][k][0];
                int ny = y + dir[move][k][1];

                if (nx < 0 || nx > N || ny < 0 || ny > M) continue;
                if (a[nx][ny] == -1) continue;

                int nmove = (move + 1) % 3;
                int ndist = dist + a[nx][ny];

                if (ndist >= dy[nx][ny][nmove]) continue;

                dy[nx][ny][nmove] = ndist;

                queue.add(new Info(nx, ny, nmove, ndist));

            }

        }


        int result = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            result = Math.min(result, dy[EX][EY][i]);
        }

        if (result == Integer.MAX_VALUE) result = -1;

        System.out.println(result);


    }


}


