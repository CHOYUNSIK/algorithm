
package fastcampus.Java369.part3.Step06_TopologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class baekjoon1516 {


    static int N;

    static ArrayList<Integer>[] graph;

    static int[] delay, indeg, time;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        delay = new int[N + 1];
        indeg = new int[N + 1];
        time = new int[N + 1];

        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int time = Integer.parseInt(st.nextToken());
            delay[i] = time;

            int next;

            while ((next = Integer.parseInt(st.nextToken())) != -1) {
                graph[next].add(i);
                indeg[i]++;
            }
        }

        bfs1516();
    }

    private static void bfs1516() {
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


        for (int i = 1; i <= N; i++) System.out.println(time[i]);
    }


}


