package inflearn.E_StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Step8 {

    static class Person {
        int id;
        int priority;

        public Person(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        Queue<Person> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.offer(new Person(i, Integer.parseInt(st.nextToken())));
        }

        while(!q.isEmpty()){
            Person temp = q.poll();
            for(Person x : q){
                if(x.priority > temp.priority){
                    q.offer(temp);
                    temp = null;
                    break;
                }
            }

            if(temp!=null){
                result++;
                if(temp.id== m) {
                    break;
                }
            }
        }





        System.out.println(result);

    }
}
