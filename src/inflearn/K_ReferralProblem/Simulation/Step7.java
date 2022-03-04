package inflearn.K_ReferralProblem.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Step7 {

    static int R = 12, C = 6, result = 0;
    static char[][] map;
    static boolean[][] visited;

    /*static List<int[]> pooyo = new ArrayList<>();*/
    static List<int[]> pooyo;
    static List<int[]> record = new ArrayList<>();

    static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[R][C];

        String str;
        for (int i = 0; i < R; i++) {
            str = br.readLine();
            map[i] = str.toCharArray();
            /*for (int j = 0; j < C; j++) {
                if (map[i][j] != '.') {
                    pooyo.add(new int[]{i, j});
                }
            }*/
        }




        while (true) {
            boolean isFinished = true;
            visited = new boolean[R][C];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] != '.') {
                        pooyo = new ArrayList<>();


                        bfs(i,j,map[i][j]);

                        if (pooyo.size() >= 4) {
                            isFinished = false;
                            for (int p = 0; p < pooyo.size(); p++) {
                                map[pooyo.get(p)[0]][pooyo.get(p)[1]] = '.';
                            }
                        }


                    }
                }
            }
            if (isFinished) break;
            fall();
            result++;
        }
        System.out.println(result);
    }

    private static void bfs(int x , int y, int c) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        pooyo.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int m = 0; m < 4; m++) {
                int nx = cur[0] + move[m][0];
                int ny = cur[1] + move[m][1];



                if(nx >= 0 && ny >= 0 && nx < R && ny < C && visited[nx][ny] == false && map[nx][ny] == c) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                    pooyo.add(new int[]{nx, ny});
                }


            }
        }
    }

    private static void fall() {
        for (int i = 0; i < C; i++) {
            for (int j = R - 1; j > 0; j--) {
                if(map[j][i] == '.'){
                    for (int k = j - 1; k >= 0; k--) {
                        if(map[k][i] != '.'){
                            map[j][i] = map[k][i];
                            map[k][i] = '.';
                            break;
                        }
                    }
                }

            }
        }
    }


}
