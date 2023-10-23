package inflearn.A_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step9_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArray = br.readLine().toCharArray();
        StringBuilder result = new StringBuilder();

        for (char c : charArray){
            if(Character.isDigit(c)) result.append(c);
        }

        System.out.println(Integer.parseInt(result.toString()));

    }
}
