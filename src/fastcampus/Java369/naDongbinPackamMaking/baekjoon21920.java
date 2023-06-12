package fastcampus.Java369.naDongbinPackamMaking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon21920 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());

        long sum = 0, cnt = 0;

        for (int i = 0; i < n; i++) {
            if (GCD(a[i], x) == 1) {
                sum += a[i];
                cnt++;
            }
        }

        System.out.printf("%.6f", (double) sum / cnt);

    }

    private static long GCD(int a, int b) {
        if (b == 0) return a;
        return GCD(b, a % b);
    }

}
