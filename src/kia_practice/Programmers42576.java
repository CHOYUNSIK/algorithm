package kia_practice;

import java.util.*;
import java.util.Collections;

public class Programmers42576 {
    public static String solution(String[] participant, String[] completion) {

        HashMap<String, Integer> map = new HashMap<>();

        for (String s : participant) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (String s : completion) {
            map.put(s, map.get(s) - 1);
        }

        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();

        String result = "";

        while (iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();

            if (next.getValue() != 0){
                result = next.getKey();
                break;
            }

        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
        System.out.println(solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"}));
        System.out.println(solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}));
    }
}
