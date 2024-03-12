package socar;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Test3 {
    public static void main(String[] args) throws Exception {

        int solution = solution(new String[]{"2016-09-15 01:00:04.002 2.0s","2016-09-15 01:00:07.000 2s"});

        System.out.println(solution);

    }

    public static int solution(String[] lines) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        int[] startTimes = new int[lines.length];
        int[] endTimes = new int[lines.length];

        for (int i = 0; i < lines.length; i++) {
            String[] log = lines[i].split(" ");
            LocalDateTime endTime = LocalDateTime.parse(log[0] + " " + log[1], formatter);
            int duration = (int) (Double.parseDouble(log[2].substring(0, log[2].length() - 1)) * 1000);
            startTimes[i] = (int) ChronoUnit.MILLIS.between(LocalDateTime.of(0, 1, 1, 0, 0), endTime) - duration + 1;
            endTimes[i] = (int) ChronoUnit.MILLIS.between(LocalDateTime.of(0, 1, 1, 0, 0), endTime);
        }

        int maxTraffic = 0;
        for (int i = 0; i < lines.length; i++) {
            int windowStart = endTimes[i];
            int windowEnd = windowStart + 1000; // 1초 후
            int currentMax = 0;
            for (int j = 0; j < lines.length; j++) {
                if (startTimes[j] < windowEnd && endTimes[j] >= windowStart) {
                    currentMax++;
                }
            }
            maxTraffic = Math.max(maxTraffic, currentMax);
        }
        return maxTraffic;
    }
}
