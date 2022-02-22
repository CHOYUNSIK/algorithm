package inflearn.K_ReferralProblem.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step1 {
    static int n, m, count = 1;
    static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[][] map;
    /*static boolean[][] visited;*/

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        /*visited = new boolean[n][m];*/

        st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cleaning(r, c, d);

        System.out.println(count);
    }

    public static void cleaning(int r, int c, int d) {
        map[r][c] = -1;

        for (int i = 0; i < 4; i++) {
            d = (d + 3) % 4;
            int nr = r + move[d][0];
            int nc = c + move[d][1];
            if (nr >= 0 && nc >= 0 && nr < n && nc < m && map[nr][nc] == 0) {
                count++;
                cleaning(nr, nc, d);
                return;
            }
        }

        int back = (d + 2) % 4;
        int br = r + move[back][0];
        int bc = c + move[back][1];

        if (br >= 0 && bc >= 0 && br < n && bc < m && map[br][bc] != 1) {
            cleaning(br, bc, d);
        }
    }

}
