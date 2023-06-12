package fastcampus.Java369.naDongbinPackamMaking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baekjoon21924 {

    static class Node implements Comparable<Node> {

        int to;
        int cost;

        public Node(int y, int c) {
            to = y;
            cost = c;
        }

        @Override
        public int compareTo(Node o) {
            return cost > o.cost ? 1 : -1;
        }
    }

    static ArrayList<Node>[] lists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        lists = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }

        long total = 0;

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            lists[x].add(new Node(y, c));
            lists[y].add(new Node(x, c));

            total += c;
        }

        boolean[] visited = new boolean[N + 1];
        int cnt = 0;
        long sum = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(1, 0));

        while (!queue.isEmpty()) {
            if (cnt == N) break;
            Node node = queue.poll();

            if (visited[node.to]) continue;
            visited[node.to] = true;

            cnt++;
            sum += node.cost;

            for (Node next : lists[node.to]) {
                if (visited[next.to]) continue;
                queue.add(next);
            }

        }

        System.out.println(cnt == N ? total - sum : -1);


    }


}
