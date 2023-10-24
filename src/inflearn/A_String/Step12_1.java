package inflearn.A_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step12_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int c = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String result = "";

        for (int i = 0; i < c; i++) {
            String replace = s.substring(0, 7).replace("#", "1").replace("*", "0");
            result += (char) Integer.parseInt(replace, 2);
            s = s.substring(7);
        }

        System.out.println(result);

    }
}
