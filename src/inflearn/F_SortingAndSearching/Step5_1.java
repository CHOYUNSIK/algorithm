package inflearn.F_SortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step5_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        boolean[] arr = new boolean[10000001];

        String result = "U";

        while (st.hasMoreTokens()) {
            int x = Integer.parseInt(st.nextToken());

            if (arr[x]) {
                result = "D";
                break;
            }
            arr[x] = true;
        }

        System.out.println(result);
    }
}
