
package fastcampus.Java369.part3.Step6_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon4803 {

    static ArrayList<Integer>[] graph;
    static int n, m, vertex_cnt, edge_cnt;
    static StringBuilder sb = new StringBuilder();

    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = 0;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) {
                break;
            }

            graph = new ArrayList[n + 1];
            visit = new boolean[n + 1];

            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[x].add(y);
                graph[y].add(x);

            }

            int result = 0;
            for (int i = 1; i <= n; i++) {
                if (visit[i]) continue;
                vertex_cnt = 0;
                edge_cnt = 0;

                dfs4803(i);

                if (edge_cnt == (vertex_cnt - 1) * 2) result++;

            }




            sb.append("Case ").append(++testcase).append(": ");

            if (result == 0) {
                sb.append("No trees.\n");
            } else if (result == 1) {
                sb.append("There is one tree.\n");
            } else {
                sb.append("A forest of ").append(result).append(" trees.\n");
            }

        }
        System.out.println(sb);

    }

    private static void dfs4803(int x) {
        vertex_cnt++;
        edge_cnt += graph[x].size();
        visit[x] = true;
        for (int y : graph[x]) {
            if (visit[y]) continue;
            dfs4803(y);
        }

    }


}
