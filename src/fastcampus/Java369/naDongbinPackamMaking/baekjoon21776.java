package fastcampus.Java369.naDongbinPackamMaking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon21776 {


    static int N;
    static boolean[] visited;

    static Set<String> result;

    static List<ArrayList<Integer>>  cardInfo  = new ArrayList<>();

    static String[] cards ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        result = new TreeSet<>();
        visited = new boolean[N + 1];

//        int[][] cardInfo = new int[N][];

        cards = new String[C + 1];

        for (int i = 0; i <= N; i++) {
            cardInfo.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int k = Integer.parseInt(st.nextToken());

            for (int j = 0; j < k; j++) {
                cardInfo.get(i).add(Integer.parseInt(st.nextToken()));
            }

        }

        for (int i = 1; i <= C; i++) {
            cards[i] = br.readLine();
        }

        List<Integer> curLoc = new ArrayList<>(Collections.nCopies(N + 1, 0));
        List<Integer> stack = new ArrayList<>();


        dfs(curLoc, stack);

        for (String x : result){
            System.out.println(x);
        }

    }

    private static void dfs(List<Integer> curLoc, List<Integer> stack) {

        if (check(curLoc)) {
            work(stack);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (curLoc.get(i) == cardInfo.get(i).size()) {
                continue;
            }


            int c = curLoc.get(i);

            curLoc.set(i, c + 1);
            stack.add(cardInfo.get(i).get(c));

            dfs(curLoc, stack);

            curLoc.set(i, c);
            stack.remove(stack.size() - 1);

        }

    }

    private static void work(List<Integer> stack) {

        String s = "";

        for (int x : stack){

            String cardOper = cards[x];

            for (String oper : cardOper.split(",")){

                if (oper.startsWith("ADD")) {
                    s = s + oper.charAt(4);
                }else {
                    int idx = Integer.parseInt(String.valueOf(oper.charAt(4)));
                    s = rmIdx(s, idx);
                }
                if (s.equals("ERROR")){
                    return;
                }
            }
        }

        if ("".equals(s)){
            result.add("EMPTY");
        }else {
            result.add(s);
        }

    }

    private static String rmIdx(String s, int idx) {
        if (s.length() <= idx){
            result.add("ERROR");
            return "ERROR";
        }

        return s.substring(0, idx) + s.substring(idx + 1);
    }

    private static boolean check(List<Integer> curLoc) {

        for (int i = 1; i <= N; i++) {
            if (curLoc.get(i) != cardInfo.get(i).size()) {
                return false;
            }
        }

        return true;

    }


}
