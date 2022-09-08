
package fastcampus.Java369.part3.Step07_ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baekjoon1753 {

    static int N, M, K;
    static int[] dist;
    static ArrayList<int[]>[] graph;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());


        dist = new int[N + 1];
        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new int[]{v, w});

        }

        bfs1753();
    }

    private static void bfs1753() {

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        for (int i = 1; i <= N; i++) dist[i] = Integer.MAX_VALUE;

        queue.add(new int[]{K, 0});
        dist[K] = 0;

        while (!queue.isEmpty()) {

            int[] cur = queue.poll();

            if (cur[1] != dist[cur[0]]) continue;

            for (int[] edge : graph[cur[0]]) {

                if (dist[cur[0]] + edge[1] >= dist[edge[0]]) continue;

                dist[edge[0]] = dist[cur[0]] + edge[1];

                queue.add(new int[]{edge[0], dist[edge[0]]});
            }
        }

        for (int i = 1; i <= N; i++) {

            if (Integer.MAX_VALUE == dist[i]) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }


}


