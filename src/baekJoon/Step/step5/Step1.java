package baekJoon.Step.step5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());

        int max = a ;
        int min = a ;

        StringBuilder sb = new StringBuilder();

        for(int i = 1 ; i < n ; i++){
            int b = Integer.parseInt(st.nextToken());
            if(max < b){
                max = b;
            }
            if(min > b){
                min = b;
            }
        }

        sb.append(min).append(" ").append(max);

        System.out.print(sb);
    }
}
