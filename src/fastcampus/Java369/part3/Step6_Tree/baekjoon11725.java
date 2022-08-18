
package fastcampus.Java369.part3.Step6_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon11725 {

    static int N;
    static ArrayList<Integer>[] graph;
    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        dfs11725(1, -1);


        for (int i = 2; i < parent.length; i++) {
            System.out.println(parent[i]);
        }


    }

    private static void dfs11725(int x, int par) {

        for (int y : graph[x]) {
            if (y == par) continue;
            parent[y] = x;
            dfs11725(y, x);
        }

    }

}
