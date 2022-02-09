package inflearn.A_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String result = "";

        for(int i=0; i < s.length(); i++){
            if(i == s.indexOf(s.charAt(i))){
                result+=s.charAt(i);
            }
        }

        System.out.println(result);
    }

}
