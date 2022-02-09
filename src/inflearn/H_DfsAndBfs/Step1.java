package inflearn.H_DfsAndBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step1 {
    static int n , total = 0;
    static String answer = "NO";
    static boolean flag = false;

    static void DFS(int v, int sum, int[] arr){
        if(flag) return;
        if(sum > total / 2)return;
        if(v == n){
            if((total - sum) == sum) {
                answer = "YES";
                flag = true;
            }
        }else{
            DFS(v+1, sum+arr[v], arr);
            DFS(v+1, sum, arr);

        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " " );

        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }

        DFS(0,0,arr);
        System.out.println(answer);
    }
}
