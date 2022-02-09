package inflearn.E_StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Step7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String result = "YES";

        String k = br.readLine();
        String s = br.readLine();

        Queue<Character> kq = new LinkedList<>();

        for (char x : k.toCharArray()) {
            kq.offer(x);
        }

        for(char x : s.toCharArray()){
            if(kq.contains(x)) {
                if(kq.poll() != x) {
                    result = "NO";
                    break;
                }
            }
        }

        if(!kq.isEmpty()){
            result = "NO";
        }


      /*
        String temp = "";

        for(char x : s.toCharArray() ){
            if (kq.contains(x)) {
                temp+=x;
            }
        }

        if(temp.equals(k)){
            result = "YES";
        }*/

        System.out.println(result);

    }
}
