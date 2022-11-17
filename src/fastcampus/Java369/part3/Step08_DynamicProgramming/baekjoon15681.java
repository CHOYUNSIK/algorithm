
package fastcampus.Java369.part3.Step08_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon15681 {


    static int[] Dy;
    static int N, R, Q;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        Dy = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        dfs15681(R, -1);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= Q; i++) {
            int U = Integer.parseInt(br.readLine());
            sb.append(Dy[U]).append('\n');
        }
        System.out.println(sb);
    }

    private static void dfs15681(int x, int prev) {
        Dy[x] = 1;
        for (int y : graph[x]) {
            if (prev == y) continue;
            dfs15681(y, x);
            Dy[x] += Dy[y];
        }
    }

}

