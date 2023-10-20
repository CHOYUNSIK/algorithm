package inflearn.A_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step2_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArray = br.readLine().toCharArray();


        StringBuilder sb = new StringBuilder();

        for (char c : charArray){
            if(Character.isLowerCase(c)) sb.append(Character.toUpperCase(c));
            else sb.append(Character.toLowerCase(c));
        }

        System.out.println(sb);
    }
}
