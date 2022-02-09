package inflearn.K_ReferralProblem.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Step18 {

    static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[][] map;

    static HashSet<String> hs ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        hs = new HashSet<>();
        map = new int[5][5];
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        String s = new String();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                DFS(i, j, 0, s);
            }
        }

        System.out.println(hs.size());

    }

    static void DFS(int x, int y, int depth, String str) {
        if(depth == 6) {
            hs.add(str);
            return;
        }

        for(int i = 0; i < 4; i++) {
            int nx = x + move[i][0];
            int ny = y + move[i][1];

            if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5) {
                continue;
            }

            DFS(nx,ny,depth+1,str+map[nx][ny]);
        }
    }
}
