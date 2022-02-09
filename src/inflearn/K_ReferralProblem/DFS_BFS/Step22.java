package inflearn.K_ReferralProblem.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Virus22 {
    int x;
    int y;

    public Virus22(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Step22 {

    static int n, m;
    static int count = 0;
    static int result = Integer.MAX_VALUE;
    static int[][] map;

    static ArrayList<Virus22> virusList = new ArrayList<>();
    static ArrayList<Integer> list = new ArrayList<>();

    static boolean[] check;

    static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    virusList.add(new Virus22(i, j));
                }
                if (map[i][j] == 0) {
                    count++;
                }
            }
        }

        /*check = new boolean[virusList.size()];*/
        if (count == 0) {
            System.out.println(0);
            return;
        }
        dfs(0, 0);
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);

    }

    private static void dfs(int depth, int start) {
        if (depth == m) {
            /*int[][] copyMap = copy();*/
            result = Math.min(result, bfs());
            return;
        }
        for (int i = start; i < virusList.size(); i++) {

            list.add(i);
            dfs(depth + 1, i + 1);
            list.remove(list.size() - 1);


            /*if (!check[i]) {
                check[i] = true;
                dfs(depth + 1, start + 1);
                check[i] = false;
            }*/

        }

    }

   /* private  static int[][] copy() {
        int[][] copyMap = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copyMap[i][j] = map[i][j] == 2 ? 0 : map[i][j];
            }
        }

        for (int i = 0; i < virusList.size(); i++) {
            if (!check[i]) {
                copyMap[virusList.get(i).x][virusList.get(i).y] = -2;
            }
        }

        return copyMap;
    }*/

    private static int bfs() {


        boolean[][] visited = new boolean[n][n];
        int[][] copy = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 || map[i][j] == 2) {
                    copy[i][j] = -map[i][j];
                } else {
                    copy[i][j] = map[i][j];
                }
            }
        }

        Queue<Virus22> q = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {

            int num = list.get(i);

            q.add(new Virus22(virusList.get(num).x, virusList.get(num).y));
            visited[virusList.get(num).x][virusList.get(num).y] = true;
            copy[virusList.get(num).x][virusList.get(num).y] = 0;
        }

        int time = 1;
        int cnt = 0;
        while (!q.isEmpty()) {
            if (result <= time) break;
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Virus22 virus = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nextX = virus.x + move[j][0];
                    int nextY = virus.y + move[j][1];

                    if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) continue;
                    if (visited[nextX][nextY]) continue;

                    if (copy[nextX][nextY] == 0) {
                        q.add(new Virus22(nextX, nextY));
                        visited[nextX][nextY] = true;
                        cnt += 1;
                        if (count == cnt) return time;
                    } else if (copy[nextX][nextY] == -2) {
                        visited[nextX][nextY] = true;
                        q.add(new Virus22(nextX, nextY));
                    }

                }
            }
            time += 1;
        }
        return Integer.MAX_VALUE;
    }
}
