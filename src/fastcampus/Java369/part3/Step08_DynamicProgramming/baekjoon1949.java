
package fastcampus.Java369.part3.Step08_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon1949 {

    static int N;
    static int[] A;
    static ArrayList<Integer>[] tree;
    static int[][] Dy;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        tree = new ArrayList[N + 1];
        Dy = new int[N + 1][2];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            tree[x].add(y);
            tree[y].add(x);
        }

        dfs1949(1, -1);

        System.out.println(Math.max(Dy[1][0], Dy[1][1]));

    }

    private static void dfs1949(int x, int prev) {
        Dy[x][1] = A[x];

        for (int y : tree[x]) {
            if (y == prev) continue;

            dfs1949(y, x);

            Dy[x][0] += Math.max(Dy[y][0], Dy[y][1]);
            Dy[x][1] += Dy[y][0];
        }


    }
}

 