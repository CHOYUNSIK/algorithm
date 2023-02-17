package fastcampus.Java369.naDongbinPackamMaking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class baekjoon22856 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        int[][] tree = new int[N + 1][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            tree[a][0] = b;
            tree[a][1] = c;
        }

        int result = 2 * (N - 1);

        for (int i = 1; tree[i][1] != -1; i = tree[i][1]) {
            result--;
        }

        System.out.println(result);
    }


}
