package baekJoon.Step.step7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int result = 0;
        for(int i = 0; i< s.length(); i++){
            result = Integer.parseInt(s.substring(i,i+1));
        }

        System.out.println(result);

    }
}
