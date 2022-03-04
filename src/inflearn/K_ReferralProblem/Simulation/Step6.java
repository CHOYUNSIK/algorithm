package inflearn.K_ReferralProblem.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Step6 {

    static int R, C, N, count = 1;
    static char[][] map;

    //static List<int[]> bombs;

    static Queue<int[]> bombs = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        String text;
        for (int i = 0; i < R; i++) {
            text = br.readLine();
            map[i] = text.toCharArray();
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'O') {
                    bombs.add(new int[]{i, j});
                }
            }
        }

        for (int i = count + 1; i <= N; i++) {
            if (i % 2 == 0) {
                bombFill();
            } else {
                explosion();
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

    }

    private static void explosion() {

        int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        while (!bombs.isEmpty()) {
            int[] curBomb = bombs.poll();
            map[curBomb[0]][curBomb[1]] = '.';
            for (int i = 0; i < 4; i++) {
                int nx = curBomb[0] + move[i][0];
                int ny = curBomb[1] + move[i][1];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C || map[nx][ny] == '.') continue;

                map[nx][ny] = '.';
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'O') {
                    bombs.add(new int[]{i, j});
                }
            }
        }

    }

    private static void bombFill() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = 'O';
            }
        }
    }
}
