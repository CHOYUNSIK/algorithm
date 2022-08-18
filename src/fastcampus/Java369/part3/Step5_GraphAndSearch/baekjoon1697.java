
package fastcampus.Java369.part3.Step5_GraphAndSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon1697 {

    static int N, K;
    static int[] dist;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist = new int[100005];
        visit = new boolean[100005];

        bfs1697();

        System.out.println(dist[K]);
    }

    private static void bfs1697() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visit[N] = true;

        while (!queue.isEmpty()) {
            int c = queue.poll();

            if (c - 1 >= 0 && !visit[c - 1]) {
                queue.add(c - 1);
                visit[c - 1] = true;
                dist[c - 1] = dist[c] + 1;
            }

            if (c + 1 <= 100000 && !visit[c + 1]) {
                queue.add(c + 1);
                visit[c + 1] = true;
                dist[c + 1] = dist[c] + 1;
            }

            if (c * 2 <= 100000 && !visit[c * 2]) {
                queue.add(c * 2);
                visit[c * 2] = true;
                dist[c * 2] = dist[c] + 1;
            }

        }

    }

}
