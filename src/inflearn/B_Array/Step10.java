package inflearn.B_Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+2][n+2];
        int cnt = 0;

        int[] maxArr = new int[5];

        StringTokenizer st = null;

        for(int i = 0; i < n+2; i++){
            if(i != 0 && i != n+1){
                st = new StringTokenizer(br.readLine(), " ");
            }
            for(int j = 0; j < n+2 ; j++){
                if(i==0){
                    arr[i][j] = 0;
                }else if (i==n+1){
                    arr[i][j] = 0;
                }else{
                    if(j==0){
                        arr[i][j] = 0;
                    }else if(j==n+1) {
                        arr[i][j] = 0;
                    }else{
                        arr[i][j] = Integer.parseInt(st.nextToken());
                    }
                }

            }
        }

        for(int i = 1; i < n+1 ; i++){
            for(int j = 1; j < n+1; j++){
                int key = arr[i][j];
                int top = arr[i-1][j];
                int down = arr[i+1][j];
                int left = arr[i][j-1];
                int right = arr[i][j+1];

                if(key <= top){
                    continue;
                }
                if(key <= down){
                    continue;
                }
                if(key <= left){
                    continue;
                }
                if(key <= right){
                    continue;
                }
                cnt++;

            }

        }

        System.out.println(cnt);


    }
}
