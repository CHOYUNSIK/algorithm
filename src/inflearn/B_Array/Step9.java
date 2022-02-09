package inflearn.B_Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step9 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int max = Integer.MIN_VALUE;
        int sum1 = 0  , sum2 =0;

        for(int i = 0; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n ; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < arr.length; i++){
            sum1 =sum2 = 0;
            for(int j =0; j < arr.length; j++){
                sum1+=arr[i][j];
                sum2+=arr[j][i];
            }
            max = Math.max(max,sum1);
            max = Math.max(max,sum2);
        }
        sum1 =sum2 = 0;
        for(int i = 0; i<arr.length; i++){
            sum1 += arr[i][i];
            sum2 += arr[i][arr.length-1-i];
        }
        max = Math.max(max,sum1);
        max = Math.max(max,sum2);
        System.out.println(max);
    }
}
