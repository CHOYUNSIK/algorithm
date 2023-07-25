package hecto;


import java.util.*;

public class Step1 {

    public int solution(int[] stats) {
        List<Integer> teams = new ArrayList<>();

        for (int stat : stats) {
            int teamIndex = -1;

            for (int i = 0; i < teams.size(); i++) {
                int maxRating = teams.get(i);
                if (stat > maxRating) {
                    if (teamIndex == -1 || maxRating > teams.get(teamIndex)) {
                        teamIndex = i;
                    }
                }
            }

            if (teamIndex == -1) {
                teams.add(stat);
            } else {
                teams.set(teamIndex, stat);
            }
        }

        return teams.size();
    }




    public static void main(String[] args) {
        Step1 solution = new Step1();
        int[] stats1 = {5, 3, 4, 6, 2, 1};
        int[] stats2 = {6, 2, 3, 4, 1, 5};

        System.out.println(solution.solution(stats1)); // Output: 4
        System.out.println(solution.solution(stats2)); // Output: 3
    }
}
