package fastcampus.Java369.naDongbinPackamMaking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class baekjoon22868 {


    static ArrayList<Integer>[] lists;
    static int S, E;

    static int[] dist, pre;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        lists = new ArrayList[N + 1];
        dist = new int[N + 1];
        pre = new int[N + 1];


        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            lists[x].add(y);
            lists[y].add(x);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(lists[i]);
        }

        st = new StringTokenizer(br.readLine(), " ");

        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());


        for (int i = 1; i <= N; i++) {
            dist[i] = pre[i] = -1;
        }
        int result1 = bfs(S, E);

        for (int i = 1; i <= N; i++) {
            dist[i] = -1;
        }
        dfs(S, E);

        int result2 = bfs(E, S);

        System.out.println(result1 + result2);

    }

    private static void dfs(int s, int e) {
        if (s == pre[e]) {
            return;
        }
        dist[pre[e]] = 0;

        dfs(s, pre[e]);

    }

    private static int bfs(int s, int e) {

        Queue<Integer> queue = new LinkedList<>();

        queue.add(s);
        dist[s] = 0;

        while (!queue.isEmpty()) {

            Integer cur = queue.poll();

            for (int x : lists[cur]) {
                if (dist[x] != -1) continue;
                dist[x] = dist[cur] + 1;
                queue.add(x);
                pre[x] = cur;
            }
        }

        return dist[e];

    }


}
