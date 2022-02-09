package inflearn.F_SortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Step10 {

    public static int count(int[] a, int mid) {
        int count = 1;
        int end = a[0];

        for(int i = 1; i < a.length; i++){
            if(a[i] - end >= mid){
                count++;
                end = a[i];
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

        Arrays.sort(a);

        int lt = 1;
        int rt = a[n-1];

        while (lt <= rt) {

            int mid = (lt + rt) / 2;

            if (count(a, mid) >= k) {
                lt = mid + 1;
                result = mid;
            } else {
                rt = mid - 1;
            }
        }
        System.out.print(result);
    }
}
