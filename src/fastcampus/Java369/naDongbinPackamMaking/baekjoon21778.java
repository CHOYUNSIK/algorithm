package fastcampus.Java369.naDongbinPackamMaking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class baekjoon21778 {

    static class Process implements Comparable<Process> {
        private Long id;
        private Long ranking;
        private Long time;

        public Process(long id, long ranking, long time) {
            this.id = id;
            this.ranking = ranking;
            this.time = time;
        }

        public void minus() {
            this.ranking = ranking - 1;
            this.time = time - 1;
        }

        public long getId() {
            return id;
        }

        @Override
        public int compareTo(Process o) {
            if (this.ranking != o.ranking) return this.ranking.compareTo(o.ranking)  ;
            return this.id.compareTo(o.id) ;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int Q = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long T = 0;

        PriorityQueue<Process> queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());
            long C = Long.parseLong(st.nextToken());

            queue.add(new Process(A, C, B));

            T += B;

        }

        int[] dy = new int[(int) (T + 1)];

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= T; i++) {

            Process poll = queue.poll();

            dy[i] = (int) poll.getId();

            poll.minus();

            if (poll.time > 0) {
                queue.add(poll);
            }

        }

        while (Q-- > 0) {
            int x = Integer.parseInt(br.readLine());

            sb.append(dy[x]).append("\n");
        }

        System.out.println(sb);


    }

}
