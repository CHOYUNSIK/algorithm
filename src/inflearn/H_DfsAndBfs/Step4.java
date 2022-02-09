package inflearn.H_DfsAndBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step4 {

    static int n, m;
    static int[] pm;

    public void DFS(int v) {
        if (m == v) {
            for (int i = 0; i < m; i++) {
                System.out.print(pm[i] + " ");
            }
            System.out.println();
        }else {
            for (int i = 1; i <= n; i++) {
                pm[v] = i;
                DFS(v+1);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        Step4 main = new Step4();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        pm = new int[m];
        main.DFS(0);
    }
}
