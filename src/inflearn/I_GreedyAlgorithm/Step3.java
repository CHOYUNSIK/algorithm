package inflearn.I_GreedyAlgorithm;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Time2 implements Comparable<Time2> {
    public int t;
    public char s;

    public Time2(int t, char s) {
        this.t = t;
        this.s = s;
    }

    @Override
    public int compareTo(Time2 o) {
        if (this.t == o.t) return this.s - o.s;
        else return this.t - o.t;
    }
}


public class Step3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Time2> list = new ArrayList<>();
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            list.add(new Time2(Integer.parseInt(st.nextToken()), 's'));
            list.add(new Time2(Integer.parseInt(st.nextToken()), 'e'));
        }

        Collections.sort(list);
        int cnt = 0;
        int result = Integer.MIN_VALUE;

        for(Time2 t : list) {
            /*System.out.println(t.t + " " + t.s);*/
            if(t.s == 's'){
                cnt++;
            }else{
                cnt--;
            }
            result = Math.max(result, cnt);
        }

        System.out.println(result);

    }
}
