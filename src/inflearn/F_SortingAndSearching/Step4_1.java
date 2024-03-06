package inflearn.F_SortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step4_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int s = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] cache = new int[s];
        int[] find = new int[n];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            find[i] = Integer.parseInt(st.nextToken());
        }

        for (int x : find) {
            int cacheIndex = -1;

            for (int i = 0; i < s; i++) {
                if (x == cache[i]) {
                    cacheIndex = i;
                }
            }

            if (cacheIndex == -1) {
                for (int i = s - 1; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
            } else {
                for (int i = cacheIndex; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
            }


            cache[0] = x;
        }

        for (int x : cache) {
            System.out.print(x + " ");
        }
    }

}
