
package fastcampus.Java369.part3.Step06_TopologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class baekjoon1005 {


    static int N, K, W;

    static ArrayList<Integer>[] graph;

    static int[] delay, indeg, time;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            time = new int[N + 1];
            indeg = new int[N + 1];
            delay = new int[N + 1];
            graph = new ArrayList[N + 1];


            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 1; i <= N; i++) {
                delay[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[x].add(y);
                indeg[y]++;

            }

            W = Integer.parseInt(br.readLine());

            bfs1005();

        }


    }

    private static void bfs1005() {

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) {
                deque.add(i);
                time[i] = delay[i];
            }
        }

        while (!deque.isEmpty()) {
            int x = deque.poll();

            for (int y : graph[x]) {
                indeg[y]--;
                if (indeg[y] == 0) deque.add(y);
                time[y] = Math.max(time[y], time[x] + delay[y]);
            }

        }

        System.out.println(time[W]);

    }


}


