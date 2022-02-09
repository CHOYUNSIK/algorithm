package inflearn.I_GreedyAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Lecture implements Comparable<Lecture> {
    public int price;
    public int day;

    public Lecture(int price, int day) {
        this.price = price;
        this.day = day;
    }

    @Override
    public int compareTo(Lecture o) {
        return o.day - this.day;
    }
}

public class Step4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<Lecture> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            list.add(new Lecture(p, d));
            if (max < d) max = d;
        }

        Collections.sort(list);

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        int j = 0;
        int result = 0;
        for (int i = max; i >= 1; i--) {
            for (; j < n; j++) {
                if (list.get(j).day < i) break;
                queue.offer(list.get(j).price);
            }
            if(!queue.isEmpty())result+= queue.poll();
        }
        System.out.println(result);
    }
}
