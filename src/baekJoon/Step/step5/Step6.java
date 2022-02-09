package baekJoon.Step.step5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Step6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i  = 0 ; i < n; i++){
            int result = 0;
            int score = 1;
            for(int j : br.readLine().toCharArray()){
                if('O'== j){
                    result += score;
                    score++;
                }else{
                    score = 1;
                }
            }
            System.out.println(result);
            br.close();

        }

    }
}
