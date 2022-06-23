package fastcampus.Java369.part3.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon10816 {


    static int lower_bound(int[] A, int L, int R, int X) {
        int ans = R + 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (A[mid] >= X) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return ans;
    }

    static int upper_bound(int[] A, int L, int R, int X) {
        int ans = R + 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (A[mid] > X) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return ans;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] cards = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        int[] numbers = new int[M + 1];
        int[] result = new int[M + 1];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= M; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards, 1, N + 1);

        for (int i = 1; i <= M; i++) {
            int x = numbers[i];
            int upper = upper_bound(cards, 1, N, x);
            int lower = lower_bound(cards, 1, N, x);

            result[i] = upper - lower;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= M; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);

    }

}
