
package fastcampus.Java369.part3.Step6_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon14267 {

    static int N, M;

    static int[] Dy;

    static ArrayList<Integer>[] children;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        children = new ArrayList[N + 1];
        Dy = new int[N + 1];


        for (int i = 1; i <= N; i++) {
            children[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= N; i++) {
            int par = Integer.parseInt(st.nextToken());
            if (i == 1) continue;
            children[par].add(i);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            Dy[x] += s;
        }

        dfs1427(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(Dy[i]).append(" ");
        }
        System.out.println(sb);

    }

    private static void dfs1427(int x) {

        for (int y : children[x]) {
            Dy[y] += Dy[x];
            dfs1427(y);
        }
    }


}
