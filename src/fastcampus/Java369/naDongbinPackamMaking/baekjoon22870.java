package fastcampus.Java369.naDongbinPackamMaking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class baekjoon22870 {

    static int N, M, S, E;
    static ArrayList<ArrayList<Pair>> lists = new ArrayList<>();
    static Long[] distS, distE;
    static int[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        distS = new Long[N];
        distE = new Long[N];
        used = new int[N];

        for (int i = 0; i < N; i++) {
            lists.add(new ArrayList<>());
            distS[i] = distE[i] = Long.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            lists.get(a).add(new Pair(b, c));
            lists.get(b).add(new Pair(a, c));
        }

        st = new StringTokenizer(br.readLine(), " ");
        S = Integer.parseInt(st.nextToken()) - 1;
        E = Integer.parseInt(st.nextToken()) - 1;

        Dijkstra(distS, S);
        Dijkstra(distE, E);

        long result = distS[E];

        eraseEdge(S, E);
        for(int i = 0; i < N; i++) distE[i] = Long.MAX_VALUE;

        Dijkstra(distE, E);

        result += distE[S];

        System.out.println(result);

    }

    private static void eraseEdge(int s, int e) {

        int pre = s;

        while (s != e) {
            int min = Integer.MAX_VALUE;
            for (Pair next : lists.get(s)) {
                int nxt = (int) next.left;
                if (nxt == pre) continue;

                if (distS[s] + next.right + distE[nxt] == distS[e]) {
                    min = Math.min(min, nxt);
                }
            }
            pre = s;
            s = min;
            if (s != e) used[s] = 1;
        }

    }

    private static void Dijkstra(Long[] dist, int s) {
        PriorityQueue<Pair> queue = new PriorityQueue<>();

        dist[s] = 0L;
        queue.add(new Pair(0, s));

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();

            if (cur.left != dist[cur.right]) continue;

            for (Pair next : lists.get(cur.right)) {

                int nxt = (int) next.left;

                if (used[nxt] == 1) continue;

                if (dist[nxt] > dist[cur.right] + next.right) {
                    dist[nxt] = dist[cur.right] + next.right;
                    queue.add(new Pair(dist[nxt], nxt));
                }

            }
        }

    }


    static class Pair implements Comparable<Pair> {

        long left;
        int right;

        public Pair(long left, int right) {
            this.left = left;
            this.right = right;
        }


        @Override
        public int compareTo(Pair o) {
            if (this.left == o.left) {
                return Integer.compare(this.right, o.right);
            }
            return Long.compare(this.left, o.left);
        }
    }


}
