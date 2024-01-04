package inflearn.D_HashMapAndTreeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Step4_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] t = br.readLine().toCharArray();

        char[] s = br.readLine().toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();

        for (char x : s) {
            map.put(x , map.getOrDefault(x, 0) + 1);
        }

        int lt = 0;

        HashMap<Character, Integer> map2 = new HashMap<>();
        int result = 0;

        for (int i = 0; i < s.length - 1; i++){
            map2.put(t[i] , map2.getOrDefault(t[i], 0) + 1);
        }

        for (int rt = s.length - 1; rt < t.length; rt++){
            map2.put(t[rt], map2.getOrDefault(t[rt], 0)+1);
            if (map.equals(map2)) result++;
            map2.put(t[lt], map2.get(t[lt])-1);
            if (map2.get(t[lt]) == 0) map2.remove(t[lt]);
            lt++;
        }

        System.out.println(result);


    }

}
