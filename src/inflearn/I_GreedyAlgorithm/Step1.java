package inflearn.I_GreedyAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Person implements Comparable<Person> {
    public int k;
    public int w;

    public Person(int k, int w) {
        this.k = k;
        this.w = w;
    }

    @Override
    public int compareTo(Person o) {
        return o.k - this.k;
    }
}

public class Step1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Person> personArrayList = new ArrayList<>();
        StringTokenizer st;

        int result = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            personArrayList.add(new Person(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        Collections.sort(personArrayList);

        for(int i =0; i < n ; i++){
            if(personArrayList.get(i).w > max){
                max = personArrayList.get(i).w;
                result++;
            }
        }
        System.out.println(result);
    }
}
