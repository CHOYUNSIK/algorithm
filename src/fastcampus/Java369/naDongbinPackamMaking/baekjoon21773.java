package fastcampus.Java369.naDongbinPackamMaking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baekjoon21773 {


    static class Process implements Comparable<Process> {
        final int id;
        int time;
        int ranking;

        public Process(int id, int time, int ranking) {
            this.id = id;
            this.time = time;
            this.ranking = ranking;
        }

        public int getId(){
            return this.id;
        }

        public int getPrio(){
            return this.ranking;
        }

        public void minus() {
            this.time -= 1;
            this.ranking -= 1;
        }

        @Override
        public int compareTo(Process o) {
            if (this.ranking != o.getPrio()) return o.getPrio() - this.ranking;
            return this.getId() - o.getId();
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int T = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        PriorityQueue<Process> queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            queue.add(new Process(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }


        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {

            Process poll = queue.poll();
            sb.append(poll.getId() + "\n");
            poll.minus();
            if (poll.time > 0) {
                queue.add(poll);
            }

        }

        System.out.println(sb.toString());
    }



}
