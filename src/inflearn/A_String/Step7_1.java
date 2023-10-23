package inflearn.A_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step7_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().toLowerCase();

        String reverse = new StringBuilder(s).reverse().toString();

        String result = "NO";

        if (reverse.equals(s)){
            result = "YES";
        }

        System.out.println(result);

    }
}
