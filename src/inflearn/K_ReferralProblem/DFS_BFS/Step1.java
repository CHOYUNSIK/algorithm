package inflearn.K_ReferralProblem.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Step1 {

    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int m,n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int a = y1; a < y2; a++) {
                for (int b = x1; b < x2; b++) {
                    map[a][b] = 1;
                }
            }
        }

        ArrayList<Integer>list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                     list.add(bfs(i, j));
                }
            }
        }

        System.out.println(list.size());
        Collections.sort(list);
        for(int x : list){
            System.out.print(x+" ");
        }
    }

    static int bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        int cnt = 1;

        while (!q.isEmpty()){
            int[] tmp = q.poll();
            int cx = tmp[0];
            int cy = tmp[1];

             for (int i = 0; i < 4; i++) {
                 int nx = cx + dx[i];
                 int ny = cy + dy[i];

                 if(nx >= 0 && ny >= 0 && nx < m && ny < n && map[nx][ny] == 0 && !visited[nx][ny]){
                     q.offer(new int[]{nx, ny});
                     visited[nx][ny] = true;
                     cnt++;
                 }
             }
        }

        return cnt;
    }
}