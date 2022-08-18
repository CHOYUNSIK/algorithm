
package fastcampus.Java369.part3.Step5_GraphAndSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon2251_BFS {

    static int[] limit;
    static boolean[][][] visit;
    static boolean[] possible;


    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        limit = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 3; i++) {
            limit[i] = Integer.parseInt(st.nextToken());
        }

        visit = new boolean[205][205][205];
        possible = new boolean[205];

        bfs2251(0, 0, limit[2]);

        for (int i = 0; i <= 200; i++) {
            if (possible[i]) sb.append(i).append(' ');
        }
        System.out.println(sb);

    }

    private static void bfs2251(int a, int b, int c) {
        Queue<Status2251> queue = new LinkedList<>();
        queue.add(new Status2251(new int[]{a, b, c}));
        visit[a][b][c] = true;

        while (!queue.isEmpty()) {
            Status2251 status2251 = queue.poll();
            if (status2251.X[0] == 0) possible[status2251.X[2]] = true;

            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    if (from == to) continue;

                    Status2251 move = status2251.move(from, to, limit);

                    if (!visit[move.X[0]][move.X[1]][move.X[2]]) {
                        visit[move.X[0]][move.X[1]][move.X[2]] = true;
                        queue.add(move);
                    }

                }
            }
        }

    }

    private static class Status2251 {

        int[] X;

        public Status2251(int[] ints) {
            X = new int[3];
            for (int i = 0; i < 3; i++) {
                X[i] = ints[i];
            }
        }

        public Status2251 move(int from, int to, int[] limit) {
            int[] nx = new int[]{X[0], X[1], X[2]};

            if (nx[from] + nx[to] <= limit[to]) {
                nx[to] = nx[to] + nx[from];
                nx[from] = 0;
            } else {
                nx[from] -= limit[to] - nx[to];
                nx[to] = limit[to];
            }
            return new Status2251(nx);
        }
    }
}
