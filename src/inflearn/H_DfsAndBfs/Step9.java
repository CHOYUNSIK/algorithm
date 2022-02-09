package inflearn.H_DfsAndBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step9 {

    static int n,m;
    static int[] combi;
    static void DFS(int v, int s){
        if(v == m){
            for (int x : combi) System.out.print(x+" ");
            System.out.println();
        }else{
            for(int i=s; i<=n; i++){
                combi[v] = i;
                DFS(v+1, i+1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        combi = new int[m];

        DFS(0,1);
    }
}
