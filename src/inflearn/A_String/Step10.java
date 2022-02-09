package inflearn.A_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        StringTokenizer st = new StringTokenizer(s, " ");

        String text = st.nextToken();
        char[] textC = text.toCharArray();
        char check = st.nextToken().charAt(0);
        int[] resultNum = new int[text.length()];
        int p = 1001;

        for(int i = 0 ; i < text.length() ; i++){

            if(textC[i]==check){
                p = 0;
                resultNum[i] = p;
            }else{
                p++;
                resultNum[i] = p;
            }

        }

        p = 1000;

        for(int i = text.length()-1 ; i >= 0 ; i--){

            if(textC[i]==check){
                p = 0;
            }else{
                p++;
                if(p<resultNum[i]){
                    resultNum[i] = p;
                }
            }

        }

        for(int i : resultNum){
            System.out.print(i+" ");
        }

    }
}
