package baekJoon.Step.step5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        StringTokenizer st ;
        int[] arr;

        for(int i=0; i < num; i++){

            st = new StringTokenizer(br.readLine()," ");
            int n = Integer.parseInt(st.nextToken());
            arr = new int[n];
            double sum = 0;

            for(int j = 0 ; j < n ; j++){

                int x = Integer.parseInt(st.nextToken());
                sum+=x;
                arr[j] = x;

            }

            double mean = sum/n;
            double  c = 0;

            for(int j = 0 ; j < arr.length; j++){
                if(arr[j] > mean){
                    c++;
                }
            }

            System.out.printf("%.3f%%\n",(c/n)*100);
        }
    }
}
