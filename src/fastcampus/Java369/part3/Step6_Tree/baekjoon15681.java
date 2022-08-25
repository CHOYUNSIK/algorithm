
package fastcampus.Java369.part3.Step6_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon15681 {

    static int N, R, Q;
    static ArrayList<Integer>[] tree;
    static int[] Dy;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());


        tree = new ArrayList[N + 1];
        Dy = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            tree[x].add(y);
            tree[y].add(x);
        }

        dfs15681(R, -1);

        for (int i = 0; i < Q; i++) {
            int q = Integer.parseInt(br.readLine());

            System.out.println(Dy[q]);


        }

    }

    private static void dfs15681(int x, int prev) {
        Dy[x] = 1;
        for (int y : tree[x]) {
            if (y == prev) continue;
            dfs15681(y, x);
            Dy[x] += Dy[y];

        }

    }

}
