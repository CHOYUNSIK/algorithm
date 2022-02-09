package baekJoon.Step.step8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int count = 1, range = 2;

        if(n == 1){
            System.out.print(1);
        }

        else{
            while (n >= range){
                range = range + (6*count);
                count++;
            }
            System.out.print(count);
        }

    }
}
