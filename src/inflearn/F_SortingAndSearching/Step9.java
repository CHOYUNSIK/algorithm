package inflearn.F_SortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Step9 {

    public static int count(int[] a, int dvd) {
        int count = 1, sum = 0;

        for (int x : a) {
            if (sum + x > dvd) {
                count++;
                sum = x;
            } else {
                sum += x;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        int k = Integer.parseInt(st.nextToken());
        int result = 0;
        st = new StringTokenizer(br.readLine(), " ");
        br.close();
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int lt = Arrays.stream(a).max().getAsInt();
        int rt = Arrays.stream(a).sum();

        while (lt <= rt) {

            int mid = (lt + rt) / 2;

            if (count(a, mid) <= k) {
                rt = mid - 1;
                result = mid;
            } else {
                lt = mid + 1;
            }
        }
        System.out.print(result);
    }
}
