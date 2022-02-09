package inflearn.E_StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Step6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= n ; i++) q.offer(i);

        while(!q.isEmpty()){
            for(int i = 1; i < k; i++){
                q.offer(q.poll());
            }
            q.poll();
            if(q.size() == 1) result = q.poll();
        }

        System.out.println(result);

    }
}
