package fastcampus.Java369.naDongbinPackamMaking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.*;

public class baekjoon21942 {

    static int N, F;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());

        String[] temp = st.nextToken().split("/");

        int day = Integer.parseInt(temp[0]);
        int hour = Integer.parseInt(temp[1].split(":")[0]);
        int minute = Integer.parseInt(temp[1].split(":")[1]);

        long limit = (hour + day * 24) * 60 + minute;


        F = Integer.parseInt(st.nextToken());

        HashMap<String, HashMap<String, LocalDateTime>> mp = new HashMap<>();
        HashMap<String, Long> find = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm");
            LocalDateTime curDate = LocalDateTime.parse(st.nextToken() + st.nextToken(), formatter);

            long curTime = Timestamp.valueOf(curDate).getTime();

            String partname = st.nextToken();
            String nickname = st.nextToken();

            if (mp.containsKey(nickname)) {
                if (mp.get(nickname).containsKey(partname)) {

                    LocalDateTime prev = mp.get(nickname).get(partname);
                    curDate = curDate.minusDays(day);
                    curDate = curDate.minusHours(hour);
                    curDate = curDate.minusMinutes(minute);
                    Duration duration = Duration.between(prev, curDate);

                    long dist = Math.max(0L, duration.getSeconds());

                    System.out.println(dist+ " dist");

                    if (find.containsKey(nickname)) {
                        long update = find.get(nickname) + dist * F;
                        find.put(nickname, update);
                    } else {
                        find.put(nickname, dist * F);
                    }
                    mp.get(nickname).remove(partname);
                } else {
                    mp.get(nickname).put(partname, curDate);
                }
            } else {
                mp.put(nickname, new HashMap<>());
                mp.get(nickname).put(partname, curDate);
            }
        }

        List<String> keyList = new ArrayList<>(find.keySet());
        keyList.sort(Comparator.naturalOrder());

        Boolean ans = false;
        StringBuilder out = new StringBuilder();
        for(String key: keyList) {
            if(find.get(key) == 0)continue;
            out.append(key + " " + find.get(key) + '\n');
            ans = true;
        }
        if(ans == false) {
            out.append("-1");
        }
        System.out.print(out);
    }

}
