package inflearn.H_DfsAndBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step8 {

    static int[][] me = new int[15][15];

    static int[] a, b, ch;

    static int n, f;
    static boolean flag = false;

    static int combi(int n, int r) {
        if (me[n][r] != 0) return me[n][r];
        if (n == r || r == 0) return 1;
        else return me[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
    }

    static void DFS(int v, int sum) {
        if(flag) return;
        if (v == n) {
            if(sum == f){
                for(int x : b) System.out.print(x+" ");
                flag = true;
            }
        } else {
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    b[v] = i;
                    DFS(v+1, sum + (a[v]*b[v]));
                    ch[i] = 0;
                }

            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());

        a = new int[n];
        b = new int[n];
        ch = new int[n + 1];

        for (int i = 0; i < n; i++) {
            a[i] = combi(n - 1, i);
        }

        DFS(0, 0);
    }
}
