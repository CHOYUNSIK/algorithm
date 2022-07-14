
package fastcampus.Java369.part3.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon13144 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N + 1];
        int[] cnt = new int[100001];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        long result = 0;
        for (int L = 1, R = 0; L <= N; L++) {

            while (R + 1 <= N && cnt[a[R + 1]] == 0) {
                R++;
                cnt[a[R]]++;
            }

            result += R - L + 1;
            cnt[a[L]]--;

        }

        System.out.println(result);

    }
}