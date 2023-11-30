package inflearn.D_HashMapAndTreeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Step2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine().toUpperCase();
        String b = br.readLine().toUpperCase();

        String result = "YES";
        HashMap<Character , Integer> map = new HashMap<>();

        for(char x : a.toCharArray()){
            map.put(x, map.getOrDefault(x,0)+1);
        }

        for(char x : b.toCharArray()){
            if(!map.containsKey(x) || map.get(x) == 0){
                result = "NO";
                System.out.print("NO");
                break;
            }
            map.put(x, map.get(x)-1);
        }

        if(result.equals("YES")){
            System.out.print(result);
        }




        /*char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();

        Arrays.sort(ac);
        Arrays.sort(bc);

        a = String.valueOf(ac);
        b = String.valueOf(bc);

        String result = "NO";

        if(a.equals(b)){
            result = "YES";
        }

        System.out.print(result);
*/
    }
}
