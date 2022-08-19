
package fastcampus.Java369.part3.Step6_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon1991 {

    static int[][] graph;
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        graph = new int[30][2];

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            char c = st.nextToken().charAt(0);
            int cur = (int) (c - 'A');
            for (int j = 0; j < 2; j++) {
                char ch = st.nextToken().charAt(0);
                if (ch != '.') graph[cur][j] = (int) (ch - 'A');
                else graph[cur][j] = -1;
            }
        }

        pre_order(0);
        sb.append("\n");
        in_order(0);
        sb.append("\n");
        post_order(0);

        System.out.println(sb);
    }

    static void in_order(int x) {
        if (x == -1) return;
        in_order(graph[x][0]);
        sb.append((char) (x + 'A'));
        in_order(graph[x][1]);
    }

    static void pre_order(int x) {
        if (x == -1) return;
        sb.append((char) (x + 'A'));
        pre_order(graph[x][0]);
        pre_order(graph[x][1]);

    }

    static void post_order(int x) {
        if (x == -1) return;
        post_order(graph[x][0]);
        post_order(graph[x][1]);
        sb.append((char) (x + 'A'));
    }


}
