
package fastcampus.Java369.part3.GraphAndSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon1389 {

    static int N, M;
    static int[] dist, result;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        for (int i = 1; i <= N; i++) {

            dist = new int[N + 1];
            visited = new boolean[N + 1];


            bfs1389(i);

            int sum = 0;
            for (int j = 1; j <= N; j++) {
                sum += dist[j];
            }
            min = Integer.min(min, sum);
            result[i] = sum;
        }

        for (int i = 1; i <= N; i++) {

            if (result[i] == min) {
                System.out.println(i);
                break;
            }

        }


    }

    private static void bfs1389(int start) {

        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int x : graph[cur]) {

                if (visited[x]) continue;

                queue.add(x);
                visited[x] = true;
                dist[x] = dist[cur] + 1;
            }
        }


    }


}
