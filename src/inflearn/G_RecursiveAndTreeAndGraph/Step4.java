package inflearn.G_RecursiveAndTreeAndGraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step4 {

    static int[] arr;

    public static int DFS(int n){
        if(arr[n] > 0) return arr[n];
        if (n == 1) return arr[n] = 1;
        else if (n == 2) return arr[n] = 1;
        else return arr[n] = DFS(n-2) + DFS(n-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        DFS(n);

        for(int i = 1 ; i <=n; i++ ){
            System.out.print(arr[i] + " ");
        }

    }
}
