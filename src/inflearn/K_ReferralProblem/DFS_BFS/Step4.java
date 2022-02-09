package inflearn.K_ReferralProblem.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Step4 {

    static int r, c;
    static char[] check;

    static String cs="";

    static char[][] map;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int result = 0;

    static void bfs(int x, int y) {
        int cnt = 1;
        //check[cnt++] = map[x][y];
        cs += Character.toString(map[x][y]);
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx >= 0 && ny >= 0 && nx < r && ny < c){

                    if(!cs.contains(Character.toString(map[nx][ny]))){
                        cs += Character.toString(map[nx][ny]);
                        cnt++;
                        q.offer(new int[]{nx,ny});
                    }

                }
            }

        }

    }

    static void dfs(int x, int y, int cnt){

        if(cs.contains(Character.toString(map[x][y]))){
            result = Math.max(result, cnt);
            return;
        }else{
            cs += Character.toString(map[x][y]);
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < r && ny < c){
                    dfs(nx, ny, cnt+1);
                }
            }
         cs=cs.replace(Character.toString(map[x][y]),"");
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        check = new char[c];

        Arrays.fill(check, '0');

        for(int i = 0; i < r; i++) {
            String str = br.readLine();
            for(int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j);
            }
        }

    /*    for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
*/
        dfs(0,0,0);
        System.out.println(result);
    }
}
