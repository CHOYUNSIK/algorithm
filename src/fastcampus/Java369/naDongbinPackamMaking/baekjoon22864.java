package fastcampus.Java369.naDongbinPackamMaking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class baekjoon22864 {

    static int A, B, C, M;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        A = Integer.parseInt(st.nextToken()); // 하루에 한 시간 일하면 피로도
        B = Integer.parseInt(st.nextToken()); //  쌓이고 일은 B 만큼 처리
        C = Integer.parseInt(st.nextToken()); // 피로도는 C 만큼 줄어든다
        M = Integer.parseInt(st.nextToken()); // 를 넘기면 일하는데 번아웃이 와서 이미 했던 일들도 다 던져버리고 일을 그만두게 된다.


        dfs(0, 0, 0);

        System.out.println(result);
    }

    private static void dfs(int a, int b, int t) {

        if (a < 0) {
            a = 0;
        }

        if (t == 24) {
            result = Math.max(result, b);
            return;
        }

        if ((a + A) > M) {
            dfs(a - C, b, t + 1);
        } else {
            dfs(a + A, b + B, t + 1);
        }

    }


}
