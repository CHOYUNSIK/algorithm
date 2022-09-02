
package fastcampus.Java369.part3.Step06_TopologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon2056 {

    static int N;
    static ArrayList<Integer>[] graph;
    static int[] indeg, delay, time;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        indeg = new int[N + 1];
        delay = new int[N + 1];
        time = new int[N + 1];
        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }


        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int t = Integer.parseInt(st.nextToken());
            delay[i] = t;
            int c = Integer.parseInt(st.nextToken());

            for (int j = 0; j < c; j++) {
                int y = Integer.parseInt(st.nextToken());
                graph[i].add(y);
                indeg[y]++;
            }
        }

        bfs2056();

    }

    private static void bfs2056() {
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
                if (indeg[y] == 0) {
                    deque.add(y);
                }

                time[y] = Math.max(time[y], time[x] + delay[y]);
            }

        }

        System.out.println(Arrays.stream(time).max().getAsInt());

    }


}
