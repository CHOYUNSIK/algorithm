
package fastcampus.Java369.part3.Step08_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon2096 {


    static int[] Dy;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] maxDp = new int[3];
        int[] minDp = new int[3];

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int x3 = Integer.parseInt(st.nextToken());

            if (i == 0) {
                maxDp[0] = minDp[0] = x1;
                maxDp[1] = minDp[1] = x2;
                maxDp[2] = minDp[2] = x3;
            } else {
                int temp1 = maxDp[0];
                int temp2 = maxDp[2];

                maxDp[0] = Math.max(maxDp[0], maxDp[1]) + x1;
                maxDp[2] = Math.max(maxDp[1], maxDp[2]) + x3;
                maxDp[1] = Math.max(Math.max(maxDp[1], temp1), temp2) + x2;


                int temp3 = minDp[0];
                int temp4 = minDp[2];

                minDp[0] = Math.min(minDp[0], minDp[1]) + x1;
                minDp[2] = Math.min(minDp[1], minDp[2]) + x3;
                minDp[1] = Math.min(Math.min(minDp[1], temp3), temp4) + x2;
            }
        }


        System.out.println(Math.max(Math.max(maxDp[0], maxDp[1]), maxDp[2]) + " " + Math.min(Math.min(minDp[1], minDp[2]), minDp[0]));

    }


}

