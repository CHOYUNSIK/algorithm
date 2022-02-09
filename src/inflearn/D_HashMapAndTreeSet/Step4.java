package inflearn.D_HashMapAndTreeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Step4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        HashMap<Character,Integer> am = new HashMap<>();
        HashMap<Character,Integer> bm = new HashMap<>();
        int result = 0;

        for(char x : b.toCharArray()){
            bm.put(x, bm.getOrDefault(x, 0)+1);
        }

        int l = b.length()-1;

        for(int i = 0; i < l ; i ++){
            am.put(a.charAt(i), am.getOrDefault(a.charAt(i), 0)+1);
        }

        int lt = 0;
        for(int rt = l ; rt < a.length(); rt ++){
            am.put(a.charAt(rt), am.getOrDefault(a.charAt(rt), 0)+1);
            if(am.equals(bm)) result++;
            am.put(a.charAt(lt), am.get(a.charAt(lt))-1);
            if(am.get(a.charAt(lt))==0) am.remove(a.charAt(lt));
            lt++;
        }

        System.out.print(result);
    }
}
