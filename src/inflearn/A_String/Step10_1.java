package inflearn.A_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step10_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        char[] charArray = st.nextToken().toCharArray();
        char t = st.nextToken().charAt(0);
        int[] result = new int[charArray.length];


        int p = 1000;

        for (int i = 0; i < charArray.length; i++) {
            if (t == charArray[i]) {
                p = 0;
            } else {
                p++;
            }
            result[i] = p;
        }

        p = 1000;
        for (int i = charArray.length - 1; i >= 0; i--) {
            if (t == charArray[i]) {
                p = 0;
            } else {
                p++;
            }

            if (p < result[i]) {
                result[i] = p;
            }

        }

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+ " ");
        }


    }
}
