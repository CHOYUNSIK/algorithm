package inflearn.I_GreedyAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {

    int vex;
    int cost;
    public Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

public class Step5 {
    static int n,m;
    static ArrayList<ArrayList<Edge>> graph ;
    static int[] dis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList<ArrayList<Edge>>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Edge>());
        }
        dis= new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b, c));
        }

        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.offer(new Edge(1,0));

        while (!q.isEmpty()){
            Edge tmp = q.poll();
            int now = tmp.vex;
            int nowCost = tmp.cost;
            if(nowCost > dis[now]) continue;
            for(Edge e : graph.get(now)) {
                if(dis[e.vex] > nowCost + e.cost) {
                    dis[e.vex] = nowCost + e.cost;
                    q.offer(new Edge(e.vex, nowCost + e.cost));
                }
            }
        }
        for(int i=2; i<=n; i++){
            if(dis[i]!=Integer.MAX_VALUE) System.out.println(i+" : "+dis[i]);
            else System.out.println(i+" : impossible");
        }
    }
}
