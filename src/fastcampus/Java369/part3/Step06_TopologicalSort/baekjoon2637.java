
package fastcampus.Java369.part3.Step06_TopologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class baekjoon2637 {

    static int N, M;

    static ArrayList<int[]>[] graph;

    static int[] indeg;

    static int[][] count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        indeg = new int[N + 1];
        count = new int[N + 1][N + 1];
        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            graph[y].add(new int[]{x, k});
            indeg[x]++;
        }


        bfs2637();

    }

    private static void bfs2637() {
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) {
                deque.add(i);
                count[i][i] = 1;
            }
        }

        while (!deque.isEmpty()) {
            int x = deque.poll();

            for (int[] info : graph[x]) {
                int y = info[0];
                int k = info[1];

                indeg[y]--;

                for (int i = 1; i <= N; i++) {
                    count[y][i] += count[x][i] * k;
                }
                if (indeg[y] == 0) deque.add(y);

            }


        }

        for (int i = 1; i <= N; i++) {
            if (count[N][i] != 0) System.out.println(i + " " + count[N][i]);
        }

    }


}
