package inflearn.J_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Step5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int amount = Integer.parseInt(br.readLine());
        int[] dy = new int[amount+1];
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;

        for(int i = 0; i < n; i++){
            for(int j = arr[i]; j <= amount; j++){
                dy[j] =  Math.min(dy[j], dy[j-arr[i]] + 1);
            }
        }
        System.out.println(dy[amount]);
    }
}
