package baekJoon.Step.step3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        StringTokenizer st = new StringTokenizer(s, " ");

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine() , " ");

        for(int i = 0 ; i < n ; i++){
            int value = Integer.parseInt(st.nextToken());

            if(x > value){
                sb.append(value).append(" ");
            }

        }

        br.close();
        System.out.println(sb);

    }
}
