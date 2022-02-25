package inflearn.K_ReferralProblem.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Step3 {

    static int N, L, R;
    static int[][] map;
    static boolean[][] check;

    static int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(populationCheck());
/*        boolean go = true;
        while (go){
            go = populationMovement();
        }
        System.out.println(COUNT);*/
    }

    private static int populationCheck() {

        int count = 0;
        boolean isMove;

        while (true) {
            check = new boolean[N][N];
            isMove = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (check[i][j]) continue;
                    if (populationMovement(i, j)) isMove = true;
                }
            }

            if (isMove) count++;
            else return count;
        }
    }

    private static boolean populationMovement(int x, int y) {

        Queue<int[]> q = new LinkedList<>();
        List<int[]> list = new LinkedList<>();

        q.offer(new int[]{x, y});
        list.add(new int[]{x, y});

        check[x][y] = true;

        int sum = map[x][y];

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + move[i][0];
                int ny = temp[1] + move[i][1];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (check[nx][ny]) continue;

                int currentCountry = map[temp[0]][temp[1]];
                int neighboringCountry = map[nx][ny];
                int populationDifference = Math.abs(neighboringCountry - currentCountry);

                if (populationDifference < L || populationDifference > R) continue;
                sum += neighboringCountry;

                q.offer(new int[]{nx, ny});
                list.add(new int[]{nx, ny});
                check[nx][ny] = true;

            }
        }

        if(list.size() == 1) return false;
        else {
            for (int[] temp : list) {
                map[temp[0]][temp[1]] = sum / list.size();
            }
            return true;
        }
    }

    /*private static boolean populationMovement() {

        boolean countCheck = false;
        boolean[][] check = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!check[i][j]) {
                    int currentCountry = map[i][j];

                    for (int m = 0; m < 4; m++) {
                        int nextX = i + move[m][0];
                        int nextY = j + move[m][1];

                        if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && check[nextX][nextY] == false) {
                            int neighboringCountry = map[nextX][nextY];
                            int populationDifference = Math.abs(neighboringCountry - currentCountry);

                            if (populationDifference >= L && populationDifference <= R) {
                                countCheck = true;
                                check[nextX][nextY] = true;
                            }
                        }
                    }
                }
                if(countCheck){
                    check[i][j] = true;
                }
            }
        }
        if(countCheck){
            COUNT++;
            int sum = 0;
            int openCount = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (check[i][j]) {
                        sum += map[i][j];
                        openCount++;
                    }
                }
            }
            int population = sum / openCount;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (check[i][j]) {
                        map[i][j] = population;
                        *//*check[i][j] = false;*//*
                    }
                }
            }

        }
        return countCheck;
    }*/
}
