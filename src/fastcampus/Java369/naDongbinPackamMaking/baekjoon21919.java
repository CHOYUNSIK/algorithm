package fastcampus.Java369.naDongbinPackamMaking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon21919 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long result = 1;

        for (int i = 1; i <= n; i++) {
            int x = Integer.parseInt(st.nextToken());

            if (isPrime(x)) {
                result = LCM(result, x);
            }
        }

        if (result == 1) result = -1;
        System.out.println(result);

    }

    private static long LCM(long a, long b) {
        return a / GCD(a, b) * b;
    }

    private static long GCD(long a, long b) {
        if (b == 0) return a;
        return GCD(b, a % b);
    }

    private static boolean isPrime(int x) {

        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) return false;
        }

        return true;
    }

}
