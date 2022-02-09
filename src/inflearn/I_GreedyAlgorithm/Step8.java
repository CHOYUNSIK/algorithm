package inflearn.I_GreedyAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge3 implements Comparable<Edge3> {
    int v;
    int cost;

    public Edge3(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge3 o) {
        return this.cost - o.cost;
    }
}

public class Step8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int[] ch = new int[v + 1];
        ArrayList<ArrayList<Edge3>> graph = new ArrayList<ArrayList<Edge3>>();
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<Edge3>());
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge3(b, c));
            graph.get(b).add(new Edge3(a, c));
        }

        PriorityQueue<Edge3> pq = new PriorityQueue<Edge3>();
        pq.add(new Edge3(1, 0));
        int result = 0;
        while (!pq.isEmpty()) {
            Edge3 cur = pq.poll();
            int cv = cur.v;
            if (ch[cv] == 0) {
                ch[cv] = 1;
                result += cur.cost;
                for (Edge3 ee : graph.get(cv)) {
                    if (ch[ee.v] == 0) {
                        pq.offer(ee);
                    }
                }
            }
        }
        System.out.println(result);

    }

}
