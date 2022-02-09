package inflearn.H_DfsAndBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step6 {
    static int n, m;
    static int[] a, ch, result;

    static void DFS(int L) {
        if (L == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
        }else{
            for (int i = 0; i < n; i++) {
                if(ch[i]==0){
                   result[L] = a[i];
                   ch[i] = 1;
                   DFS(L+1);
                   ch[i] = 0;
                }

            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n];
        ch = new int[n];
        result = new int[m];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        DFS(0);
    }
}
