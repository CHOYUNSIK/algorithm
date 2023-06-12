package fastcampus.Java369.naDongbinPackamMaking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon22859 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String html = br.readLine();


        int L = 0, E = html.length();

        while (L < E) {
            int index = html.indexOf("title=\"", L);

            if (index == -1) break;

            int endTitle = html.indexOf("\">", index);

            int endDiv = html.indexOf("</div>", index);

            String title = html.substring(index + 7, endTitle);

            System.out.println("title : " + title);

            int cur = L;

            while (true) {
                int startP = html.indexOf("<p>", cur);

                if (startP == -1) break;
                if (startP > endDiv) break;

                int endP = html.indexOf("</p>", startP);

                String pTag = html.substring(startP + 3, endP);

                String p = characterExtraction(pTag);

                System.out.println(p);

                cur = endP;
            }

            L = endDiv;

        }

    }

    private static String characterExtraction(String pTag) {

        String s = "";
        boolean tagOpen = false;
        boolean spacing = true;

        for (int i = 0; i < pTag.length(); i++) {
            if (pTag.charAt(i) == '<') {
                tagOpen = true;
                continue;
            }
            if (pTag.charAt(i) == '>') {
                tagOpen = false;
                continue;
            }
            if (tagOpen) {
                continue;
            }

            if (pTag.charAt(i) == ' ') {
                if (spacing) continue;
                spacing = true;
                s += pTag.charAt(i);
            } else {
                spacing = false;
                s += pTag.charAt(i);
            }

        }


        return s.trim();
    }
}
