package baekJoon.Step.step7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] a = new int[26];

        for(int i = 0; i < s.length(); i++ ){
            char ch = s.charAt(i);

            if('A' <= ch && ch <= 'Z'){
                a[ch-'A']++;
            }
            else{
                a[ch-'a']++;
            }

        }

        int max = -1;
        char ch = '?';

        for(int i =0 ; i < 26 ; i++){

            if(max < a[i]){
                max = a[i];
                ch = (char)(i+65);
            }

            else if(max == a[i]){
                ch = '?';
            }

        }

        System.out.print(ch);

    }
}
