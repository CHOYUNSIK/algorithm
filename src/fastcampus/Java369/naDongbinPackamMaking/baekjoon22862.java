package fastcampus.Java369.naDongbinPackamMaking;

import java.awt.font.FontRenderContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class baekjoon22862 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        int removal_count = 0;

        for (int i = 0, r = 0; i < N; i++) {
            while (r < N) {
                if (arr[r] % 2 == 0) r++;
                else {
                    if (removal_count == K) break;
                    removal_count++;
                    r++;
                }
            }
            result = Math.max(result, r - i - removal_count);
            if (arr[i] % 2 == 1) removal_count--;
        }

        System.out.println(result);

    }


}
