package inflearn.K_ReferralProblem.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Step10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[][] direct = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();
        char[][] map = new char[r][c];
        boolean flag = true;

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            map[i] = st.nextToken().toCharArray();
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'W') {
                    q.add(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + direct[i][0];
                int ny = y + direct[i][1];
                if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
                if (map[nx][ny] == 'D' || map[nx][ny] == 'W') continue;
                if (map[nx][ny] == 'S') {
                    System.out.println(0);
                    q.clear();
                    flag = false;
                    break;
                }
                map[nx][ny] = 'D';
            }
        }

        if(flag){
            System.out.println(1);
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
    }
}
