package baekJoon.Step.step7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] a = new int[26];

        for(int i = 0; i < a.length; i++){
            a[i] =  -1;
        }

        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);

            if(a[c-'a'] == -1){
                a[c-'a'] = i;
            }

        }

        for(int x : a){
            System.out.print(x+" ");
        }

    }
}
