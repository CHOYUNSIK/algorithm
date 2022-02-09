package inflearn.H_DfsAndBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step7 {
    static int[][] me = new int[35][35];

    static int DFS(int n, int r) {
        if(me[n][r] != 0) return me[n][r];
        if(r==n) return 1;
        if(r == 0) return 1;
        else{
            return me[n][r] = DFS(n-1 , r-1) + DFS(n-1 , r);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        System.out.print(DFS(n,r));
    }
}
