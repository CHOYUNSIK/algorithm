package inflearn.H_DfsAndBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Step5 {
    static int m,n,result=Integer.MAX_VALUE;
    static Integer[] kind;
    public void DFS(int L, int sum){
        if(sum > m) return;
        if(L >= result) return;
        if(m == sum){
            result = Math.min(result,L);
        }
        else{
            for(int i = 0; i < n; i++){
                DFS(L+1,sum+kind[i]);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        kind = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < n; i++ ){
            kind[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(kind, Collections.reverseOrder());

        m = Integer.parseInt(br.readLine());

        Step5 main = new Step5();

        main.DFS(0,0);
        System.out.println(result);
    }
}
