
package fastcampus.Java369.part3.Step06_TopologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class baekjoon9470 {


    static int M, K, P;

    static ArrayList<Integer>[] graph;
    static int[] indeg, order, maxCnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            K = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());

            graph = new ArrayList[M + 1];
            indeg = new int[M + 1];
            order = new int[M + 1];
            maxCnt = new int[M + 1];

            for (int i = 1; i <= M; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < P; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                graph[A].add(B);
                indeg[B]++;
            }

            bfs9470();

        }


    }

    private static void bfs9470() {

        Deque<Integer> queue = new LinkedList<>();


        for (int i = 1; i <= M; i++) {
            if (indeg[i] == 0) {
                queue.add(i);
                order[i] = maxCnt[i] = 1;
            }

        }
        int ans = 0;
        while (!queue.isEmpty()) {
            int x = queue.poll();

            if (maxCnt[x] >= 2) order[x]++;
            ans = Math.max(ans, order[x]);
            for (int y : graph[x]) {
                indeg[y]--;
                if (indeg[y] == 0) {
                    queue.add(y);
                }

                if (order[x] == order[y]) maxCnt[y]++;
                else if (order[y] < order[x]) {
                    order[y] = order[x];
                    maxCnt[y] = 1;
                }
            }

        }

        System.out.println(K + " " + ans);
    }

}
