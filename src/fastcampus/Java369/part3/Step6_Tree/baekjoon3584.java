
package fastcampus.Java369.part3.Step6_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon3584 {


    static int N;
    static int[] per, check;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {

            N = Integer.parseInt(br.readLine());

            per = new int[N + 1];
            check = new int[N + 1];

            for (int i = 1; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                per[v] = u;
            }

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            while (x > 0) {
                check[x] = 1;
                x = per[x];
            }

            while (y > 0 && check[y] == 0) {
                y = per[y];
            }

            System.out.println(y);

        }

    }

}
