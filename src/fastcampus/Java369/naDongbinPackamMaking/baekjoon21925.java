package fastcampus.Java369.naDongbinPackamMaking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baekjoon21925 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;

        for (int i = 0, j; i < N; ) {
            boolean find = false;
            for (j = i + 1; j < N; j += 2 ) {
                boolean check = true;
                int L = i, R = j;
                while (L < R){
                    if (a[L] != a[R]){
                        check = false;
                        break;
                    }
                    L ++; R--;
                }

                if (check){
                    result++;
                    find = true;
                    break;
                }
            }

            if (!find){
                result = -1;
                break;
            }

            i = j + 1;
        }

        System.out.println(result);

    }


}
