
package fastcampus.Java369.part3.Step06_TopologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon2623 {

    static int N, M;
    static ArrayList<Integer>[] graph;
    static int[] indeg;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        indeg = new int[N + 1];

        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int count, x, y;

            count = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());

            for (int j = 2; j <= count; j++) {
                y = Integer.parseInt(st.nextToken());
                graph[x].add(y);
                indeg[y]++;
                x = y;
            }
        }

        bfs2623();
    }

    private static void bfs2623() {

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) {
                queue.add(i);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int x = queue.poll();
            result.add(x);
            for (int y : graph[x]) {
                indeg[y]--;
                if (indeg[y] == 0) queue.add(y);
            }
        }

        if (result.size() == N) {
            for (int x : result) {
                System.out.println(x);
            }
        } else {
            System.out.println(0);
        }

    }

}
