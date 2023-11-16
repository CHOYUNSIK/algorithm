package inflearn.D_HashMapAndTreeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;

public class Step1_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        char[] array = br.readLine().toCharArray();

        HashMap<Character, Integer> map = new HashMap<>();

        for (char x : array){
            Integer i = map.computeIfAbsent(x, character -> 0) ;
            map.put(x, i + 1);
        }

        int max = 0;
        char result = 0;

        Set<Character> characters = map.keySet();

        for (char x : characters){
            int v = map.get(x);
            if (max < v){
                max = v;
                result = x;
            }
        }

        System.out.println(result);

    }
}
