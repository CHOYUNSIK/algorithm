package fastcampus.Java369.mockCodingTest.Step01_CodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon20168 {

    static int N, M, A, B, C, result;

    static boolean[] visited;

    static ArrayList<int[]>[] list;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        result = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new int[]{b, c});
            list[b].add(new int[]{a, c});
        }

        visited[A] = true;
        dfs20168(A, C, -1);

        if (result == Integer.MAX_VALUE) result = -1;

        System.out.println(result);

    }

    private static void dfs20168(int node, int money, int cost) {
        if (node == B) {
            result = Math.min(result, cost);
            return;
        }

        if (money <= 0) return;

        for (int[] next : list[node]) {

            if (visited[next[0]] || next[1] > money) continue;

            visited[next[0]] = true;

            dfs20168(next[0], money - next[1], Math.max(cost, next[1]));

            visited[next[0]] = false;

        }


    }


}
