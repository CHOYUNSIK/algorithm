package kurly;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Step2 {

    static class Burger {
        int heatTime;
        int eatTime;

        public Burger(int heatTime, int eatTime) {
            this.heatTime = heatTime;
            this.eatTime = eatTime;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Burger[] burgers = new Burger[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            burgers[i] = new Burger(0, Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int heatTime = Integer.parseInt(st.nextToken());
            burgers[i].heatTime = heatTime;
        }

        Arrays.sort(burgers, (b1, b2) -> Integer.compare(b1.eatTime, b2.eatTime));

        int result = calculate(burgers);

        System.out.println(result);

    }

    private static int calculate(Burger[] burgers) {
        int n = burgers.length;
        int[] finishTimes = new int[n];


        finishTimes[0] = burgers[0].heatTime + burgers[0].eatTime;
        for (int i = 1; i < n; i++) {
            finishTimes[i] = Math.max(burgers[i].heatTime + finishTimes[i - 1], burgers[i].heatTime + burgers[i].eatTime);
        }

        return finishTimes[n - 1];
    }


}
