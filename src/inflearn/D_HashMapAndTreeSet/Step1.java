package inflearn.D_HashMapAndTreeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Step1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s  = br.readLine();

        Map<Character, Integer> map  = new HashMap<>();

        for(char x : s.toCharArray()){
            map.put(x,map.getOrDefault(x,0)+1);
        }

        int max = Integer.MIN_VALUE;
        String result = "";
        for(char key : map.keySet()){
            if(max < map.get(key)){
                max = map.get(key);
                result = String.valueOf(key);
            }
        }
        System.out.print(result);
    }
}
