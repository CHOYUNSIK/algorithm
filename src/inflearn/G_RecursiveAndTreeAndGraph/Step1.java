package inflearn.G_RecursiveAndTreeAndGraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step1 {

    public static void DFS(int n){
        if(n == 0){
            return;
        }else {
            DFS(n-1);
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        DFS(n);
    }
}
