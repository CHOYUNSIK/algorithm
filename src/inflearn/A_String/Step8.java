package inflearn.A_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().toUpperCase();
        s = s.replaceAll("[^A-Z]", "");

        String result = "NO";

        if(s.equals(new StringBuilder(s).reverse().toString())){
            result="YES";
        }

        br.close();


        System.out.println(result);
    }

}
