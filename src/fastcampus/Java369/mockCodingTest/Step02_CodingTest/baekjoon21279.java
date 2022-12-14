package fastcampus.Java369.mockCodingTest.Step02_CodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon21279 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        ArrayList<long[]>[] xx = new ArrayList[100001];
        ArrayList<long[]>[] yy = new ArrayList[100001];

        for (int i = 0; i < 100001; i++) {
            xx[i] = new ArrayList<>();
            yy[i] = new ArrayList<>();
        }


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            long x = Integer.parseInt(st.nextToken());
            long y = Integer.parseInt(st.nextToken());
            long v = Long.parseLong(st.nextToken());

            xx[(int) x].add(new long[]{y, v});
            yy[(int) y].add(new long[]{x, v});
        }

        long mx = 0;
        long curval = 0;
        int curnum = 0;
        int xlim = 0;
        int ylim = 100000;


        while (xlim <= 100000){
            for (int i = 0; i < xx[xlim].size(); i++){
                if (xx[xlim].get(i)[0] > ylim) continue;
                curval += xx[xlim].get(i)[1];
                curnum++;
            }

            while (c < curnum){
                for (int i = 0; i < yy[ylim].size(); i++){
                    if (yy[ylim].get(i)[0] > xlim) continue;
                    curval -= yy[ylim].get(i)[1];
                    curnum--;
                }
                ylim--;
            }

            xlim++;

            if (mx < curval) mx = curval;

        }

        System.out.println(mx);

    }
}

