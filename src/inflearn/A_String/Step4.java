package inflearn.A_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i  = 0 ; i < n ; i++){
            String result = new StringBuilder(br.readLine()).reverse().toString();
            System.out.println(result);
        }
    }

}
