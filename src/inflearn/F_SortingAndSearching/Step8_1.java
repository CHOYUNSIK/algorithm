package inflearn.F_SortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Step8_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int result = 0;

        int lt = 0;
        int rt = n - 1;

        while (lt <= rt) {
            result++;
            int mid = (lt + rt) / 2;

            if (arr[mid] == m) {
                System.out.println(mid+1);
                break;
            }

            if (arr[mid] < m) {
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }

        }
    }
}
