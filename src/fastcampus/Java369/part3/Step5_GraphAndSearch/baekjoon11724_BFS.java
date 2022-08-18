
package fastcampus.Java369.part3.Step5_GraphAndSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon11724_BFS {

    static int N, M, count;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;
            bfs11724(i);
            count++;
        }
        System.out.println(count);


    }

    private static void bfs11724(int i) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(i);
        visited[i] = true;

        while (!queue.isEmpty()){

            int cur = queue.poll();

            for (int x : graph[cur]){
                if (visited[x]) continue;

                queue.offer(x);
                visited[x] = true;
            }

        }

    }

}