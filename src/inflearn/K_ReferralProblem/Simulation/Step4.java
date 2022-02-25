package inflearn.K_ReferralProblem.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step4 {
    static int N, L;
    static int[][] map;
    static boolean[][] ramp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map= new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (installation(i, 0, 0)) {
                count++;
            }
            if (installation(0, i, 1)) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean installation(int x, int y, int flag) {
        int[] height = new int[N];
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            height[i] = flag == 0 ? map[x][i] : map[i][y];
        }

        for (int i = 0; i < N-1; i++) {
            if (height[i] == height[i + 1]) {
                continue;
            }
            if (Math.abs(height[i] - height[i + 1]) > 1) {
                return false;
            }

            if (height[i] - 1 == height[i + 1]) { // 내리막
                for (int j = i + 1; j <= i + L; j++) {
                    if(j >= N || height[j] != height[i+1] || visited[j]){
                        return false;
                    }
                    visited[j] = true;
                }
            }

            if (height[i] + 1 == height[i + 1]) { //오리막
                for(int j = i ;  j > i - L; j-- ){
                    if(j < 0 || height[j] != height[i] || visited[j]){
                        return false;
                    }
                    visited[j] = true;
                }
            }

        }
        return true;
    }
}
