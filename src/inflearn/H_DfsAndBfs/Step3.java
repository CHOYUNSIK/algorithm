package inflearn.H_DfsAndBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step3 {

    static int m,n,result=Integer.MIN_VALUE;
    static int[] a,b;

    public void DFS(int v, int sum, int time){
        if(time > m) return;
        if(v == n){
            result = Math.max(result, sum);
        }
        else{
            DFS(v+1, sum+a[v], time+b[v]);
            DFS(v+1, sum, time);
        }

    }

    public static void main(String[] args) throws IOException {

        Step3 main = new Step3();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n];
        b = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }

        main.DFS(0,0,0);
        System.out.println(result);
    }
}
