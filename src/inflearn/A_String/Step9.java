package inflearn.A_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step9 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().toUpperCase();
        int result = 0;
        String temp = "";

        for(char c : s.toCharArray()){
            /*if(c >= 48 && c <= 57){
                result = result * 10 + (c-48);
            }*/

            if(Character.isDigit(c)){
                temp += c;
                result = Integer.parseInt(temp);
            }

        }
        System.out.println(result);
    }

}
