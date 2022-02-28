package inflearn.K_ReferralProblem.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 * R 열 50
 * C 행 50
 * T 초 1000
 * 각 칸  1000
 * 2,500,000
 */
public class Step5 {
    static int R, C, T;
    static int map[][];

    static int airPurifier = -1;
    static List<Dust> fineDust = new ArrayList<>();

    static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};


    static class Dust {
        int x;
        int y;
        int n;

        public Dust(int x, int y, int n) {
            this.x = x;
            this.y = y;
            this.n = n;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (airPurifier == -1 && map[i][j] == -1) {
                    airPurifier = i;
                }
            }
        }


        for (int i = 0; i < T; i++) {
            fineDustDiffusion(); //미세먼지 확산
            airPurifierOperation(); //공기청정기 작동
        }

        int result = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                //System.out.print(map[i][j] + " ");
                if(map[i][j] == -1) continue;
                result += map[i][j];
            }
            //System.out.println();
        }
        System.out.println(result);

    }

    private static void airPurifierOperation() {

        int top = airPurifier;
        int down = airPurifier + 1;

        for (int i = top - 1; i > 0; i--) {
            map[i][0] = map[i - 1][0];
        }
        for (int i = 0; i < C - 1; i++) {
            map[0][i] = map[0][i + 1];
        }
        for (int i = 0; i < top; i++) {
            map[i][C - 1] = map[i + 1][C - 1];
        }
        for (int i = C - 1; i > 1; i--) {
            map[top][i] = map[top][i - 1];
        }
        map[top][1] = 0;

        for (int i = down + 1; i < R - 1; i++) {
            map[i][0] = map[i + 1][0];
        }
        for (int i = 0; i < C - 1; i++) {
            map[R - 1][i] = map[R - 1][i + 1];
        }
        for (int i = R - 1; i > down; i--) {
            map[i][C - 1] = map[i - 1][C - 1];
        }
        for (int i = C - 1; i > 1; i--) {
            map[down][i] = map[down][i - 1];
        }
        map[down][1] = 0;

    }

    private static void fineDustDiffusion() {


        Queue<Dust> q = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            for(int j = 0; j < C ; j++){
                if(map[i][j] != -1 && map[i][j] != 0 ){
                    q.offer(new Dust(i,j,map[i][j]));
                }
            }

        }

        while (!q.isEmpty()) {

            Dust curFineDust = q.poll();
            if (curFineDust.n < 5) continue;
            int fineDustDiffusion = curFineDust.n / 5;

            int count = 0;

            for (int j = 0; j < 4; j++) {
                int nextFineDustX = curFineDust.x + move[j][0];
                int nextFineDustY = curFineDust.y + move[j][1];

                if (nextFineDustX < 0 || nextFineDustY < 0 || nextFineDustX >= R || nextFineDustY >= C || map[nextFineDustX][nextFineDustY] == -1) continue;
                map[nextFineDustX][nextFineDustY] += fineDustDiffusion;

                count++;
            }
            map[curFineDust.x][curFineDust.y] -= (fineDustDiffusion * count);
        }
    }

}
