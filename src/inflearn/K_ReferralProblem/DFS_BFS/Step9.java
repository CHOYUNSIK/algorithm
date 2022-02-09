package inflearn.K_ReferralProblem.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step9 {

    static int n, m, h;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken()); // 세로선의 개수
        m = Integer.parseInt(st.nextToken()); // 가로선의 개수
        h = Integer.parseInt(st.nextToken()); // 세로선마다 가로선을 놓을 수 있는 위치의 개수

        map = new int[h + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[a][b + 1] = 2;
        }

/*        for (int i = 0; i <= h; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }*/

        if (searchOrderNum() > 3) {
            System.out.println(-1);
            return;
        } else {
            for (int i = 0; i <= 3; i++) {
                if(dfs(1, 1, 0, i)) return;
            }
        }
        System.out.println(-1);
    }

    static boolean dfs(int x, int y, int cnt, int size) {
        if (cnt == size) {
            if(check()){
                System.out.println(size);
                return true;
            }
            return false;
        }

        for (int i = x; i <= h; i++) {
            for (int j = y; j < n; j++) {
                if (map[i][j] != 0 || map[i][j + 1] != 0) continue;
                map[i][j] = 1;
                map[i][j + 1] = 2;
                if(dfs(x, y + 2, cnt + 1, size)) return true;
                map[i][j] = 0;
                map[i][j + 1] = 0;
            }
            y=1;
        }
        return false;
    }

    static boolean check() {
        for (int i = 1; i <= n; i++) {
            int nx = i;
            int ny = 1;

            while (ny <= h) {
                if (map[ny][nx] == 1) nx++; // 우측으로 이동
                else if (map[ny][nx] == 2) nx--; // 좌측으로 이동
                ny++; // y축+1칸 이동한다. (아래로 이동)
            }

            if (nx != i) return false; // i번으로 출발해서 i번으로 도착하지 않는게 하나라도 있다면 리턴.
        }

        return true;
    }

    static int searchOrderNum() {
        int orderNum = 0;
        for (int i = 1; i < n; i++) {
            int num = 0;
            for (int j = 1; j <= h; j++) {
                if (map[j][i] == 1) {
                    num++;
                }
            }
            if (num % 2 == 1) orderNum++;
        }

        return orderNum;
    }

}
