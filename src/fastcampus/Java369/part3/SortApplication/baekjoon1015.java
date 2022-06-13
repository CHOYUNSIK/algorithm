package fastcampus.Java369.part3.SortApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon1015 {


    static class NumberIdx implements Comparable<NumberIdx> {
        int num;
        int idx;


        public NumberIdx(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }

        @Override
        public int compareTo(NumberIdx o) {
            return  this.num - o.num;
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] P = new int[N];
        NumberIdx[] B = new NumberIdx[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {

            B[i] = new NumberIdx(Integer.parseInt(st.nextToken()), i);
        }

        Arrays.sort(B);
        
        for (int i = 0; i < N; i++) {
            P[B[i].idx] = i;
        }


        for (int i = 0; i < N; i++) {
            System.out.print(P[i]+" ");
        }

    }
}