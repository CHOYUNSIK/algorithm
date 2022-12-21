
package fastcampus.Java369.mockCodingTest.Step03_CodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baekjoon22254 {

    static int N, X;
    static int[] a;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        a = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int L = 1;
        int R = N;
        int result = N;

        while (L <= R) {

            int mid = (L + R) / 2;

            if (check(mid)) {
                R = mid - 1;
                result = mid;
            } else {
                L = mid + 1;
            }

        }

        System.out.println(result);


    }

    private static boolean check(int num) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 1; i <= num; i++) {
            queue.add(0);
        }

        for (int i = 1; i <= N; i++) {
            int poll = queue.poll();
            if (poll + a[i] > X) return false;
            queue.add(poll + a[i]);
        }

        return true;
    }

}

