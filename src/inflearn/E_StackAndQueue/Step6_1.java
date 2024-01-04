package inflearn.E_StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Step6_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++){
            queue.add(i);
        }

        int cnt  = 0;
        while (queue.size() != 1){
            Integer poll = queue.poll();
            cnt ++;
            if(cnt != k){
                queue.add(poll);
            }else {
                cnt = 0;
            }
        }

        System.out.println(queue.poll());
    }
}
