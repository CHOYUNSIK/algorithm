package hanwhalife;


import java.util.*;

public class Step2 {

    public int[] solution(int num_teams, String[] remote_tasks, String[] office_tasks, String[] employees) {
        Set<Integer> remoteWorkers = new HashSet<>();
        Set<Integer> officeWorkers = new HashSet<>();

        for (String task : remote_tasks) {
            for (String employee : employees) {
                String[] info = employee.split(" ");
                int teamNumber = Integer.parseInt(info[0]);
                String tasks = info[1];

                if (tasks.contains(task)) {
                    remoteWorkers.add(teamNumber);
                }
            }
        }

        for (String task : office_tasks) {
            for (String employee : employees) {
                String[] info = employee.split(" ");
                int teamNumber = Integer.parseInt(info[0]);
                String tasks = info[1];

                if (tasks.contains(task)) {
                    officeWorkers.add(teamNumber);
                }
            }
        }

        remoteWorkers.removeAll(officeWorkers);

        List<Integer> result = new ArrayList<>();
        for (String employee : employees) {
            String[] info = employee.split(" ");
            int teamNumber = Integer.parseInt(info[0]);
            if (remoteWorkers.contains(teamNumber)) {
                result.add(teamNumber);
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        Arrays.sort(answer);

        return answer;
    }





    public static void main(String[] args) {
        Step2 solution = new Step2();
        int num_teams1 = 3;
        String[] remote_tasks1 = {"development", "marketing", "hometask"};
        String[] office_tasks1 = {"recruitment", "education", "officetask"};
        String[] employees1 = {"1 development hometask", "1 recruitment marketing", "2 hometask", "2 development marketing hometask", "3 marketing", "3 officetask", "3 development"};
        int[] result1 = solution.solution(num_teams1, remote_tasks1, office_tasks1, employees1);
        System.out.println(Arrays.toString(result1)); // [1, 4, 5, 7]

        int num_teams2 = 2;
        String[] remote_tasks2 = {"design"};
        String[] office_tasks2 = {"building", "supervice"};
        String[] employees2 = {"2 design", "1 supervice building design", "1 design", "2 design"};
        int[] result2 = solution.solution(num_teams2, remote_tasks2, office_tasks2, employees2);
        System.out.println(Arrays.toString(result2)); // [3, 4]
    }
}


