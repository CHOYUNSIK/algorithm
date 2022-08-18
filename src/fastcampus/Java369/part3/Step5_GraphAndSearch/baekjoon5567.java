
package fastcampus.Java369.part3.Step5_GraphAndSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon5567 {

    static int N, M;
    static ArrayList<Integer>[] graph;

    static int[] dist;
    static boolean[] visit;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());


        dist = new int[N + 1];
        visit = new boolean[N + 1];
        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        bfs5567();

        int result = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] == 1 || dist[i] == 2 ) result++;
        }
        System.out.println(result);

    }

    private static void bfs5567() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visit[1] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int x : graph[cur]) {

                if (visit[x]) continue;
                queue.add(x);
                visit[x] = true;
                dist[x] = dist[cur] + 1;
            }

        }

    }


}
