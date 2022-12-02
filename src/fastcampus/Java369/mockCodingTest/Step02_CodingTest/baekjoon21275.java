package fastcampus.Java369.mockCodingTest.Step02_CodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon21275 {

    static long[] limit = new long[38];
    static long MAX = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 2; i <= 36; i++) limit[i] = MAX / i;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String str1 = st.nextToken();
        String str2 = st.nextToken();

        int aa = -1;
        int bb = -1;

        for (int a = 2; a <= 36; a++) {
            long v1 = calc(str1, a);
            if (v1 == -1L) continue;

            for (int b = 2; b <= 36; b++) {
                if (a == b) continue;

                long v2 = calc(str2, b);

                if (v1 == v2) {
                    if (aa != -1L) {
                        System.out.println("Multiple");
                        return;
                    }

                    aa = a;
                    bb = b;
                }

            }

        }

        if (aa == -1) System.out.println("Impossible");
        else System.out.println(calc(str1, aa) + " " + aa + " " + bb);

    }

    private static long calc(String str, int n) {

        long ret = 0;

        for (int i = 0; i < str.length(); i++) {
            if (limit[n] < ret) return -1L;
            ret *= n;

            if (trans(str.charAt(i)) >= n || limit[n] - trans(str.charAt(i)) < ret) return -1L;
            ret += trans(str.charAt(i));
        }

        return ret;

    }

    private static long trans(char x) {
        if ('0' <= x && x <= '9') return (x - '0');
        return 10L + x - 'a';
    }

}
