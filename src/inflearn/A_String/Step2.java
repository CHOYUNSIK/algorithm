package inflearn.A_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String result = "";

        for(char c : str.toCharArray()){
            if(Character.isUpperCase(c)){
                result+=Character.toLowerCase(c);
            }else{
                result+=Character.toUpperCase(c);
            }
        }
        System.out.println(result);
    }

}
