package inflearn.F_SortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] c = new int[Integer.parseInt(st.nextToken())];
        int n = Integer.parseInt(st.nextToken());
        int[] a = new int[n];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        for (int x : a) {
            int pos = -1;
            for (int i = 0; i < c.length; i++) {
                if (x == c[i]) {
                    pos = i;
                }
            }
            if (pos == -1) {
                for (int i = c.length - 1; i >= 1; i--) {
                    c[i] = c[i - 1];
                }
            } else {
                for (int i = pos; i >= 1; i--) {
                    c[i] = c[i - 1];
                }
            }
            c[0] = x;
        }

        for(int x : c){
            System.out.print(x+" ");
        }

    }
}
