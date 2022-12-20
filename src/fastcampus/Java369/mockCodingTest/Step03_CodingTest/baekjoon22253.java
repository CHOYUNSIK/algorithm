
package fastcampus.Java369.mockCodingTest.Step03_CodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon22253 {


    static int N;
    static int[] a;
    static ArrayList<Integer>[] tree;
    static int[][] dy;

    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        a = new int[N + 1];
        dy = new int[N + 1][10];
        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) tree[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            tree[x].add(y);
            tree[y].add(x);
        }

        dfs22253(1, -1);


        int result = 0;
        for (int i = 0; i <= 9; i++) {
            result += dy[1][i];
            result %= MOD;
        }

        System.out.println(result);
    }

    private static void dfs22253(int x, int par) {
        dy[x][a[x]] = 1;

        for (int y : tree[x]) {
            if (y == par) continue;
            dfs22253(y, x);

            for (int i = 0; i <= 9; i++) {
                dy[x][i] += dy[y][i];
                dy[x][i] %= MOD;
            }

            for (int i = a[x]; i <= 9; i++) {
                dy[x][a[x]] += dy[y][i];
                dy[x][a[x]] %= MOD;
            }

        }

    }
}

