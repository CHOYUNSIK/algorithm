
package fastcampus.Java369.part3.Step6_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon20364 {

    static int N, Q;
    static boolean[] state;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        state = new boolean[N + 1];

        StringBuilder sb = new StringBuilder();

        while (Q-- > 0) {
            int x = Integer.parseInt(br.readLine());
            int y = x;
            int result = 0;

            while (x > 0){
                if (state[x]) result = x;
                x >>= 1;
            }

            state[y] = true;

            sb.append(result).append("\n");

        }

        System.out.println(sb);
    }

}
