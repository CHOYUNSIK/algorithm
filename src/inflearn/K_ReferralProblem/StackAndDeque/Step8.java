package inflearn.K_ReferralProblem.StackAndDeque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

public class Step8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String key = br.readLine();
        String text = br.readLine();

        int start = 0;
        int end = text.length() - 1;

        //Deque<Character> deque = new ArrayDeque<>();
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        boolean isRemove = false;


        while (start <= end) {

            if (!isRemove) {
                left.push(text.charAt(start++));
                if (left.size() >= key.length() && left.peek() == key.charAt(key.length() - 1)) {
                    int keyLen = key.length() - 1;
                    boolean check = true;
                    for (int i = left.size() - 1; i >= left.size() - key.length(); i--) {
                        if (left.get(i) != key.charAt(keyLen--)) {
                            check = false;
                            break;
                        }
                    }
                    if (check) {
                        isRemove = true;
                        for (int i = 0; i < key.length(); i++) {
                            left.pop();
                        }
                    }
                }
            }
            if (isRemove && start <= end) {
                String keyRev = new StringBuilder(key).reverse().toString();
                right.push(text.charAt(end--));
                if (right.size() >= key.length() && right.peek() == keyRev.charAt(key.length() - 1)) {
                    int keyLen = key.length() - 1;
                    boolean check = true;
                    for (int i = right.size() - 1; i >= right.size() - key.length(); i--) {
                        if (right.get(i) != keyRev.charAt(keyLen--)) {
                            check = false;
                            break;
                        }
                    }
                    if(check){
                        isRemove = false;
                        for(int i = 0; i < key.length(); i++){
                            right.pop();
                        }
                    }
                }
            }

        }
        int leftSize = left.size();

        for(int i = 0; i < leftSize; i++){
            right.push(left.pop());
        }

        StringBuilder sb = new StringBuilder();
        while(!right.isEmpty()){
            sb.append(right.pop());
        }

        while (true){
            int idx = sb.indexOf(key);
            if(idx < 0) break;

            sb.delete(idx,idx+key.length());

        }
        System.out.print(sb);




    }
}
