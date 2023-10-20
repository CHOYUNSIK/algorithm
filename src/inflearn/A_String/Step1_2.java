package inflearn.A_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step1_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s = br.readLine().toLowerCase().toCharArray();
        char c = br.readLine().charAt(0);
        int result = 0;

        for (int i = 0; i < s.length; i++) {
            if(c == s[i]) result ++;
        }

        System.out.println(result);

    }
}
