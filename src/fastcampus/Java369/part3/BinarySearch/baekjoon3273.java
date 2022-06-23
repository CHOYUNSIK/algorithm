package fastcampus.Java369.part3.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon3273 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n + 1];


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());

        Arrays.sort(a);

        int result = 0;

        for (int i = 1; i <= n; i++) {
            int L = i+1;
            int R = n;
            while (L <= R) {
                int mid = (L + R) / 2;

                if (a[i] + a[mid] == x) {
                    result++;
                    break;
                }
                if (a[i] + a[mid] < x) {
                    L = mid + 1;
                }else{
                    R = mid - 1;
                }
            }
        }

        System.out.println(result);

    }

}
