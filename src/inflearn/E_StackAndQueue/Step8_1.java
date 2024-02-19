package inflearn.E_StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Step8_1 {

    static class Person {
        int id;
        int risk;

        public Person(int id, int risk) {
            this.id = id;
            this.risk = risk;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int result = 0;


        Queue<Person> queue = new LinkedList<>();

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            queue.add(new Person(i, Integer.parseInt(st.nextToken())));
        }

        while (!queue.isEmpty()) {

            Person temp = queue.poll();

            for (Person x : queue){
                if (x.risk > temp.risk){
                    queue.add(temp);
                    temp = null;
                    break;
                }
            }


            if (temp != null){
                result++;
                if (temp.id == m){
                    System.out.println(result);
                    break;
                }
            }


        }


    }
}
