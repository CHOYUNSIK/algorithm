package inflearn.C_TwoPointersAndSlidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());

        int count = 0 ;
        int sum = 0;

        // 수학적 방법
        int cnt = 1;
        n--;
        while(n>0){
            cnt++;
            n = n - cnt;
            if(n%cnt == 0) count++;
        }


/*
        two pointers 방법
        
        int[] a = new int[n/2+1];
        int lt = 0;
        for(int i = 0; i < n/2+1; i++){
            a[i] = i+1;
        }

        for(int rt = 0; rt < n/2+1; rt++){
            sum+=a[rt];
            if(sum == n ) count++;
            while (sum >= n){
                sum-=a[lt++];
                if(sum == n ) count++;
            }
        }
*/


       /* int p = 0;
        for(int i = 1; i < n; i++ ){
            sum+=i;
            if(sum == n){
                count++;
                sum = 0;
                p++;
                i = p;
            }else if (sum > n){
                sum = 0;
                p ++ ;
                i = p;
            }
        }*/
        System.out.print(count);
    }
}
