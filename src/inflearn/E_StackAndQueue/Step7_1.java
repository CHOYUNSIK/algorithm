package inflearn.E_StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Step7_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] a = br.readLine().toCharArray();

        char[] b = br.readLine().toCharArray();

        Queue<Character> queue = new LinkedList<>();

        for (char c : a){
            queue.add(c);
        }

        String result = "YES";

        for (char x : b){
            if (queue.contains(x)){
                if (queue.poll() != x){
                    result = "NO";
                    break;
                }
            }
        }

        if (!queue.isEmpty()){
            result = "NO";
        }


        System.out.println(result);


    }
}
