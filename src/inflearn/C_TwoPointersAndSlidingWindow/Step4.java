package inflearn.C_TwoPointersAndSlidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int count = 0;
        int n = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n ; i ++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        int lt = 0;

        for(int rt = 0; rt < n; rt++){
            sum += a[rt];
            if(sum == m) count++;
            while(sum >= m){
                sum -= a[lt++];
                if(sum == m) count++;
            }
        }

        /*
        int p = -1;
        for(int i = 0; i < n; i++){
            sum+=a[i];
            if (sum == m){
                count++;
                p++;
                i = p;
                sum = 0;
            }else if(sum>m){
                p++;
                i = p;
                sum = 0;
            }
        }*/

        System.out.println(count);
    }
}
