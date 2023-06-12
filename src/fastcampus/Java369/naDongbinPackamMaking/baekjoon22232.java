package fastcampus.Java369.naDongbinPackamMaking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class baekjoon22232 {


    static class File implements Comparable<File> {
        String fileName;
        String extension;

        int isNotExist;

        public File(String fileName, String extension) {
            this.fileName = fileName;
            this.extension = extension;
        }

        public void setIsNotExist(int isNotExist) {
            this.isNotExist = isNotExist;
        }

        @Override
        public int compareTo(File o) {
            if (this.fileName.compareTo(o.fileName) != 0) {
                return this.fileName.compareTo(o.fileName);
            }
            if (this.isNotExist != o.isNotExist) {
                return this.isNotExist - o.isNotExist;
            }
            return this.extension.compareTo(o.extension);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<File> list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), ".");
            list.add(new File(st.nextToken(), st.nextToken()));
        }

        Map<String, String> eSet = new HashMap<>();

        for (int i = 0; i < M; i++) {
            eSet.put(br.readLine(), " ");
        }

        for (int i = 0; i < N; i++) {
            if (eSet.containsKey(list.get(i).extension)) {
                list.get(i).setIsNotExist(0);
            } else {
                list.get(i).setIsNotExist(1);
            }
        }

        Collections.sort(list);

        for (int i = 0; i < N; i++) {
            System.out.println(list.get(i).fileName + "." + list.get(i).extension);
        }

    }


}
