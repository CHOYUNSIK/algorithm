package inflearn.A_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step3_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        StringTokenizer st =new StringTokenizer(s, " ");

        String result = "";

        while (st.hasMoreTokens()){
            String token = st.nextToken();
            if (result.length() < token.length()){
                result = token;
            }
        }

        System.out.println(result);
    }

}
