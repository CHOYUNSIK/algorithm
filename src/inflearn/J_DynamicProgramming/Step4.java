package inflearn.J_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Step4 {

    static class bd implements Comparable<bd> {
        public int s;
        public int h;
        public int w;

        public bd(int s, int h, int w) {
            this.s = s;
            this.h = h;
            this.w = w;
        }

        @Override
        public int compareTo(bd o) {
            return o.s - this.s;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        ArrayList<bd> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            list.add(new bd(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list);

        int result = 0;
        arr[0] = list.get(0).h;
        for (int i = 1; i < n; i++) {
            int max = 0;
            for(int j = i-1; j >= 0; j--) {
                if(list.get(j).w > list.get(i).w && arr[j] > max) {
                    max = arr[j];
                }
            }
            arr[i] = list.get(i).h + max;
            result = Math.max(result, arr[i]);
        }
        System.out.println(result);
    }
}
