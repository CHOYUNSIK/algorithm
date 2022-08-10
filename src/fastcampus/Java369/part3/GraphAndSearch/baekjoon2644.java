
package fastcampus.Java369.part3.GraphAndSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon2644 {


    static int N, P1, P2, M;
    static ArrayList<Integer>[] graph;
    static boolean[] visit;

    static int[] dist;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());


        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        visit = new boolean[N + 1];
        dist = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        P1 = Integer.parseInt(st.nextToken());
        P2 = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }

        bfs2644();
        System.out.println(dist[P2]);
    }

    private static void bfs2644() {

        Arrays.fill(dist, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(P1);
        visit[P1] = true;
        dist[P1] = 0;

        while (!queue.isEmpty()) {

            int cur = queue.poll();

            for (int i = 0; i < graph[cur].size(); i++) {
                int next = graph[cur].get(i);
                if (visit[next]) continue;
                queue.add(next);
                visit[next] = true;
                dist[next] = dist[cur] + 1;
            }

        }

    }


}
