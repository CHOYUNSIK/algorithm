
package fastcampus.Java369.part3.Step6_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon9489 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            if (N == 0 && K == 0) break;

            int[] tree = new int[N + 1], par = new int[N + 1];

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 1; i <= N; i++) {
                tree[i] = Integer.parseInt(st.nextToken());
            }

            par[0] = -1;
            par[1] = 0;

            int last = 1;

            for (int i = 2; i <= N; i++, last++) {
                for (; i <= N; i++) {
                    par[i] = last;
                    if (i < N && tree[i] + 1 != tree[i + 1]) {
                        break;
                    }
                }
            }

            int findIdx = 0;
            for (int i = 1; i <= N; i++) {
                if (tree[i] == K) findIdx = i;
            }

            int result = 0;
            for (int i = 1; i <= N; i++) {
                if (par[par[i]] == par[par[findIdx]] && par[i] != par[findIdx]) {
                    result++;
                }
            }

            System.out.println(result);

        }

    }
}
