package inflearn.A_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().toUpperCase();

        String result = "YES";

        for(int i = 0; i < s.length()/2 ; i++){
            if(s.charAt(i) != s.charAt(s.length()-1-i)){
                result="NO";
            }
        }

        System.out.println(result);

       /* String sb = new StringBuilder(s).reverse().toString();
        if(s.equalsIgnoreCase(sb)){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }*/

    }

}
