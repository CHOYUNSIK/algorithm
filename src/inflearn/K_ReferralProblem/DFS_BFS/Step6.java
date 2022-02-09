package inflearn.K_ReferralProblem.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step6 {
    static int n;
    static int[][] map;
    static boolean[] check;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        check = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(min);
    }

    static void dfs(int idx, int count) {
        if (count == n / 2) {
            combi();
            return;
        } else {
            for (int i = idx; i < n; i++) {
                if (!check[i]) {
                    check[i] = true;
                    dfs(i + 1, count + 1);
                    check[i] = false;
                }
            }
        }
    }

    static void combi() {
        int start = 0;
        int link = 0;

        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                if(check[i] == true && check[j] == true){
                    start += map[i][j];
                    start += map[j][i];
                }
                if(check[i] == false && check[j] == false){
                    link += map[i][j];
                    link += map[j][i];
                }
            }
        }

        int sum = Math.abs(start - link);

        if(sum == 0){
            System.out.println(sum);
            System.exit(0);
        }

        min = Math.min(min,sum);

    }
}
