package inflearn.B_Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        int[] result = new int[n];


        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        for(int i = 0 ; i < n; i++){
            int cnt = 1;
            for(int j = 0; j < arr.length; j++ ){
                if(arr[i] < arr[j]){
                    cnt++;
                }
            }
            result[i] = cnt;
        }

        for(int x : result){
            System.out.print(x+" ");
        }

    }
}
