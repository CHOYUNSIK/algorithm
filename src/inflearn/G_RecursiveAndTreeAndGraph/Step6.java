package inflearn.G_RecursiveAndTreeAndGraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step6 {

    static int n ;
    static int[] ck;

    public static void DFS(int a){
        if(a == n+1){
            String temp = "";
            for(int i = 1 ; i <= n; i++){
                if(ck[i] == 1){
                    temp += (i+" ");
                }
            }
           if(temp.length() > 0) System.out.println(temp);
        }else{
            ck[a] = 1;
            DFS(a+1);
            ck[a] = 0;
            DFS(a+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ck = new int[n+1];
        DFS(1);


    }
}
