package fastcampus.Java369.naDongbinPackamMaking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon21921 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] a = new int[N];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0, cnt = 0, max = Integer.MIN_VALUE;

        for (int s = 0, e = 0; e < N; ) {
            while (e - s < X) sum += a[e++];
            if (max < sum) {
                max = sum;
                cnt = 1;
            } else if (max == sum) {
                cnt++;
            }
            sum -= a[s++];
        }

        if (max == 0) {
            System.out.print("SAD");
        } else {
            System.out.println(max);
            System.out.println(cnt);
        }

    }


}
