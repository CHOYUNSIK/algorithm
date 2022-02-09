package inflearn.I_GreedyAlgorithm;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Edge2 implements Comparable<Edge2> {

    public int v1;
    public int v2;
    public int cost;

    public Edge2(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge2 o) {
        return this.cost - o.cost;
    }
}

public class Step7 {
    static int[] unf;

    public static int find(int v) {
        if (v == unf[v]) return unf[v];
        else return unf[v] = find(unf[v]);
    }

    public static void union(int v1, int v2) {
        int fa = find(v1);
        int fb = find(v2);
        if (fa != fb) {
            unf[fa] = fb;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        unf = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            unf[i] = i;
        }
        ArrayList<Edge2> arr = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr.add(new Edge2(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        int result = 0;
        Collections.sort(arr);

        for (Edge2 edge2 : arr) {
            if (find(edge2.v1) != find(edge2.v2)) {
                result += edge2.cost;
                union(edge2.v1, edge2.v2);
            }
        }

        System.out.println(result);

    }
}
