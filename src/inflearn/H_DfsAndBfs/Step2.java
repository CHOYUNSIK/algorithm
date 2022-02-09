package inflearn.H_DfsAndBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step2 {

    static int n,c,result=Integer.MIN_VALUE ;
    static int[] arr;

    static void DFS(int v, int sum){
        if(c < sum) return;
        if(v == n) {
            result = Math.max(result, sum);
        }
        else{
            DFS(v+1, sum+arr[v]);
            DFS(v+1, sum);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        DFS(0,0);
        System.out.print(result);
    }
}
