package fastcampus.Java369.naDongbinPackamMaking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class baekjoon22234 {


    static class People {

        private int id;
        private int requiredTime;
        private int processingTime;
        private int maximumTime;

        public People(int id, int requiredTime, int maximumTime) {
            this.id = id;
            this.requiredTime = requiredTime;
            this.maximumTime = maximumTime;
        }

        public int getStatus() {

            if (requiredTime == 0) {
                return -1;
            } else if (processingTime >= maximumTime) {
                processingTime = 0;
                return 1;
            }

            return 0;

        }

        public void working() {
            requiredTime--;
            processingTime++;
        }

        public int getId() {
            return id;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        Deque<People> deque = new ArrayDeque<>();
        People[] customers = new People[200001];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            deque.add(new People(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), T));
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            People people = new People(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), T);

            int comeTime = Integer.parseInt(st.nextToken());

            if (comeTime <= 200000){
                customers[comeTime] = people;
            }

        }

        for (int i = 0; i < W; i++) {
            if (customers[i] != null) {
                deque.add(customers[i]);
            }
            People cur = deque.poll();

            switch (cur.getStatus()) {
                case -1:
                    break;
                case 1:
                    deque.addLast(cur);
                    break;
                case 0:
                    deque.addFirst(cur);
                    break;
            }

            cur = deque.peek();
            System.out.println(cur.getId());
            cur.working();

        }

    }


}
