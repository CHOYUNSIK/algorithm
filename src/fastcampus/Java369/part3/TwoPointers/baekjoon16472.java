package fastcampus.Java369.part3.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon16472 {

    static int kind;
    static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());

        String text = br.readLine();
        cnt = new int[26];

        int len = text.length();

        int result = 0;

        for (int R = 0, L = 0; R < len; R++) {
            addText(text.charAt(R));

            while (kind > N) {
                deleteText(text.charAt(L++));
            }

            result = Math.max(result, R - L + 1);
        }
        System.out.println(result);

    }

    private static void deleteText(char charAt) {
        cnt[charAt - 'a']--;
        if (cnt[charAt - 'a'] == 0) {
            kind--;
        }
    }

    private static void addText(char charAt) {
        cnt[charAt - 'a']++;
        if (cnt[charAt - 'a'] == 1) {
            kind++;
        }

    }


}