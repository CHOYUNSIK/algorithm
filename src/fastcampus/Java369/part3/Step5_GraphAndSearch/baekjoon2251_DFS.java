
package fastcampus.Java369.part3.Step5_GraphAndSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon2251_DFS {

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

        State2251DFS state = new State2251DFS(new int[]{0, 0, limit[2]});
        visit[0][0][limit[2]] = true;
        dfs2251(state);

        for (int i = 0; i <= 200; i++)
            if (possible[i]) sb.append(i).append(' ');

        System.out.println(sb);

    }

    private static void dfs2251(State2251DFS state) {

        if (state.X[0] == 0) possible[state.X[2]] = true;

        for (int from = 0; from < 3; from++) {
            for (int to = 0; to < 3; to++) {
                if (from == to) continue;

                State2251DFS nst = state.move(from, to, limit);

                if (!visit[nst.X[0]][nst.X[1]][nst.X[2]]) {
                    visit[nst.X[0]][nst.X[1]][nst.X[2]] = true;
                    dfs2251(nst);
                }

            }
        }
    }


    private static class State2251DFS {
        int[] X;

        public State2251DFS(int[] ints) {
            X = new int[3];

            for (int i = 0; i < 3; i++) {
                X[i] = ints[i];
            }
        }

        public State2251DFS move(int from, int to, int[] limit) {

            int[] nx = new int[]{X[0], X[1], X[2]};

            if (X[from] + X[to] <= limit[to]) {
                nx[to] = nx[from] + nx[to];
                nx[from] = 0;
            } else {
                nx[from] -= limit[to] - nx[to];
                nx[to] = limit[to];
            }

            return new State2251DFS(nx);
        }
    }
}
