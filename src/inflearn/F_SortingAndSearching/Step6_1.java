package inflearn.F_SortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Step6_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] h = new int[n];

        for (int i = 0; i < n; i++) {
            h[i] = Integer.parseInt(st.nextToken());
        }
        int[] temp = h.clone();


        Arrays.sort(temp);

        for (int i = 0; i < n; i++) {
            if (h[i] != temp[i]) System.out.print(i+1 + " ");
        }
    }

}
