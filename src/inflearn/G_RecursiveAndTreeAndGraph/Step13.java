package inflearn.G_RecursiveAndTreeAndGraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Step13 {
    static int n, m, result = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] chk;

    public static void DFC(int v){
        if(v==n) result++;
        else{
            for(int x : graph.get(v)){
                if(chk[x] == 0 ){
                    chk[x] = 1;
                    DFC(x);
                    chk[x] = 0;
                }
            }
        }
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        chk = new int[n + 1];
        graph = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }

        chk[1] = 1;
        DFC(1);
        System.out.println(result);
    }
}
