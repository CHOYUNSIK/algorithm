package inflearn.B_Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step3_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            int ac = a[i];
            int bc = b[i];

            if(ac > bc && ac - bc == 1){
                System.out.println("A");
            }else if(ac > bc && ac - bc == 2){
                System.out.println("B");
            } else if (bc > ac && bc - ac == 1) {
                System.out.println("B");
            } else if (bc > ac && bc - ac == 2) {
                System.out.println("A");
            }else {
                System.out.println("D");
            }

        }

    }
}
