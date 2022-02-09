package baekJoon.Step.step5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str ;
        int big = Integer.MIN_VALUE;
        int count = 0;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 9; i++){
            str = br.readLine();
            int in = Integer.parseInt(str);
            if(big < in){
                big = in;
                count = i+1;
            }
        }

        br.close();
        sb.append(big).append("\n").append(count);
        System.out.print(sb);
    }
}
