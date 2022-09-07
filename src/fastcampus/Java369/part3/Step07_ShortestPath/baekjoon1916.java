
package fastcampus.Java369.part3.Step07_ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baekjoon1916 {

    static int N, M, start, end;
    static int[] dist;
    static ArrayList<int[]>[] graph;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        dist = new int[N + 1];
        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[from].add(new int[]{to, weight});
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());


        bfs1916();
        System.out.print(dist[end]);
    }

    private static void bfs1916() {

        for (int i = 1; i <= N; i++) dist[i] = Integer.MAX_VALUE;

        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        queue.add(new int[]{start, 0});
        dist[start] = 0;

        while (!queue.isEmpty()) {

            int[] cur = queue.poll();

            if (dist[cur[0]] != cur[1]) continue;

            for (int[] edge : graph[cur[0]]) {

                if (dist[cur[0]] + edge[1] >= dist[edge[0]]) continue;

                dist[edge[0]] = dist[cur[0]] + edge[1];
                queue.add(new int[]{edge[0], dist[edge[0]]});
            }

        }

    }


}


