package fastcampus.Java369.mockCodingTest1.Step01_CodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon20182 {

    static int N, M, A, B;
    static long C;

    static ArrayList<Info>[] list;

    static long max = Long.MAX_VALUE;

    static long[] d;


    static class Info implements Comparable<Info> {

        int idx;
        long cost;

        public Info(int idx, long cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Info o) {

            if (cost > o.cost) return 1;
            if (cost == o.cost) return 0;
            return -1;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Long.parseLong(st.nextToken());

        list = new ArrayList[N + 1];
        d = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Info(b, c));
            list[b].add(new Info(a, c));
        }


        long left = 1;
        long right = 1000000001;
        long result = right;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (dijkstra(mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        if (result == 1000000001) System.out.println(-1);
        else System.out.println(result);


    }

    private static boolean dijkstra(long x) {

        PriorityQueue<Info> queue = new PriorityQueue<>();

        Arrays.fill(d, max);
        d[A] = 0;
        queue.add(new Info(A, 0));
        while (!queue.isEmpty()) {

            Info cur = queue.poll();

            if (cur.cost != d[cur.idx]) continue;

            for (Info next : list[cur.idx]) {
                if (next.cost > x) continue;

                if (d[next.idx] > d[cur.idx] + next.cost) {
                    d[next.idx] = d[cur.idx] + next.cost;
                    queue.add(new Info(next.idx, d[next.idx]));
                }

            }

        }

        return d[B] <= C;
    }


}
