package inflearn.A_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step12 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String result = "";

        for(int i=0; i < n; i++ ){
            String x = s.substring(0,7);
            x = x.replace("#","1").replace("*","0");

            result += (char)Integer.parseInt(x,2);
            s=s.substring(7);
        }
        System.out.println(result);
    }
}
