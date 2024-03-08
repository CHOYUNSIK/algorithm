package codingInterviewCompleteAnalysis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step1_1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();


        if (s.length() > 128) {
            System.out.println(false);
            System.exit(1);
        }

        boolean[] c = new boolean[128];

        boolean result = true;

        for (char x : s.toCharArray()){
            if (c[x]){
                result = false;
                break;
            }
            c[x] = true;
        }

        System.out.println(result);


    }
}
