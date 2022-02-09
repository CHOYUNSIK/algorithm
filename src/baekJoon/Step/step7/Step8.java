package baekJoon.Step.step7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int sum = 0;
        for(int i =0; i< s.length(); i++){
            char ch  = s.charAt(i);

            switch (ch){
                case 'A': case 'B': case 'C':{
                    sum+=2;
                    break;
                }
                case 'D': case 'E': case 'F':{
                    sum+=3;
                    break;
                }
                case 'G': case 'H': case 'I':{
                    sum+=4;
                    break;
                }
                case 'J': case 'K': case 'L':{
                    sum+=5;
                    break;
                }
                case 'M': case 'N': case 'O':{
                    sum+=6;
                    break;
                }
                case 'P': case 'Q': case 'R': case 'S':{
                    sum+=7;
                    break;
                }
                case 'T': case 'U': case 'V':{
                    sum+=8;
                    break;
                }
                case 'W': case 'X': case 'Y': case 'Z':{
                    sum+=9;
                    break;
                }

            }
        }

        sum+=s.length();

        System.out.print(sum);

    }
}
