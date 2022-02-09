package inflearn.F_SortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < n; i++ ){
            int temp = a[i], j;
            for(j = i-1; j >= 0 ; j--){
                if(temp < a[j]){
                    a[j+1] = a[j];
                }
                else break;
            }
            a[j+1] = temp;
        }

        for (int x : a) {
            System.out.print(x + " ");
        }

    }
}
