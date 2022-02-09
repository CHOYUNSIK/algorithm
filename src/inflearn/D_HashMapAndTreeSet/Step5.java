package inflearn.D_HashMapAndTreeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Step5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int result = -1;

        int n = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        TreeSet<Integer> tm = new TreeSet<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int l = j + 1; l < n; l++) {
                    tm.add(a[i] + a[j] + a[l]);
                }
            }
        }

        int cnt = 0;
        for(int x : tm){
            cnt++;
            if(cnt == m){
                result = x;
                break;
            }
        }

        System.out.println(result);


    }
}
