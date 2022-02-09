package inflearn.C_TwoPointersAndSlidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] a = new int[n];

        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < n ; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }


        int lt = 0 , cnt = 0 , max =0;

        for(int rt = 0 ; rt < n; rt++){
            if(a[rt] == 0) cnt++;
            while(cnt > k){
                if(a[lt] == 0) cnt--;
                lt++;
            }
            max = Math.max(max , rt-lt+1);
        }
        System.out.print(max);

/*        int c = 0;
        int cnt = 0;
        int p = -1;
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){
            if(a[i] == 1){
                cnt++;
            }else if(a[i]==0 && c < k){
                cnt++;
                c++;
            }else{
                if(max < cnt){
                    max = cnt;
                }
                cnt = 0;
                c= 0;
                p++;
                i=p;
            }
        }
        if(max < cnt){
            max = cnt;
        }
        System.out.print(max);*/
    }
}
