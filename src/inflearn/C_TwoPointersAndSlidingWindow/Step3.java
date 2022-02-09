package inflearn.C_TwoPointersAndSlidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int max = 0;

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n ; i ++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

    /*    for(int i = 0; i < n - (k-1) ; i++){
            int sum = 0;
            for(int j = i; j < k+i ; j++){
                sum += arr[j];
            }
            if(sum > max){
                max = sum;
            }
        }*/

        for(int i = 0; i < k; i++){
            max += arr[i];
        }

        int sum = max;
        for(int i = k; i < n; i++ ){
            sum += arr[i];
            sum -= arr[i-k];
            if(sum > max){
                max = sum;
            }
        }


        System.out.print(max);
    }
}
