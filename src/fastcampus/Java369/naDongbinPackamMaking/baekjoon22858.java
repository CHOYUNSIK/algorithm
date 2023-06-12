package fastcampus.Java369.naDongbinPackamMaking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon22858 {

    static int N;

    static int[] S;
    static int[] D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        S = new int[N + 1];
        D = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            D[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= K; i++) {
            simul();
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(S[i] + " ");
        }

    }

    static void simul() {
        int[] temp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            temp[D[i]] = S[i];
        }

        S = temp;

    }


}
