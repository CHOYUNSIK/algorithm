package inflearn.A_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step11_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArray = br.readLine().toCharArray();

        char now = charArray[0];
        int cnt = 1;

        StringBuilder sb = new StringBuilder()
                .append(now);


        for (int i = 1; i < charArray.length; i++) {
            if (now == charArray[i]) {
                cnt++;
            } else {
                if (cnt > 1) sb.append(cnt);
                now = charArray[i];
                sb.append(now);
                cnt = 1;
            }
        }

        if (cnt > 1) sb.append(cnt);

        System.out.println(sb);

    }
}
