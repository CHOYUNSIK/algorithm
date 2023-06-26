package hanwhalife;


import java.util.*;

public class Step1 {
    public static String[] solution(String[] logs) {
        String[] deduplicatedLogs2 = new HashSet<>(Arrays.asList(logs)).toArray(new String[0]);
        Map<String, Integer> problemCounts = new HashMap<>();
        Set<String> users = new HashSet<>();

        for (String log : deduplicatedLogs2) {
            String[] parts = log.split(" ");
            String user = parts[0];
            String problem = parts[1];

            problemCounts.put(problem, problemCounts.getOrDefault(problem, 0) + 1);
            users.add(user);
        }

        List<String> wellKnownProblems = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : problemCounts.entrySet()) {
            String problem = entry.getKey();
            int count = entry.getValue();
            int totalUsers = users.size();

            if (count >= (totalUsers + 1) / 2) {
                wellKnownProblems.add(problem);
            }
        }

        Collections.sort(wellKnownProblems);
        return wellKnownProblems.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Step1 solution = new Step1();

        String[] logs1 = {"morgan string_compare", "felix string_compare", "morgan reverse", "rohan sort", "andy reverse", "morgan sqrt"};
        String[] result1 = solution(logs1);
        System.out.println(Arrays.toString(result1));  // [reverse, string_compare]

        String[] logs2 = {"morgan sort", "felix sort", "morgan sqrt", "morgan sqrt", "rohan reverse", "rohan reverse"};
        String[] result2 = solution(logs2);
        System.out.println(Arrays.toString(result2));  // [sort]

        String[] logs3 = {"kate sqrt"};
        String[] result3 = solution(logs3);
        System.out.println(Arrays.toString(result3));  // [sqrt]
    }

}
