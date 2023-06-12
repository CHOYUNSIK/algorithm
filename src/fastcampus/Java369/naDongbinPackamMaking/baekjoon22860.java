package fastcampus.Java369.naDongbinPackamMaking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class baekjoon22860 {

    static class Folder {
        String name;
        TreeSet<String> files = new TreeSet<>();
        ArrayList<Folder> folders = new ArrayList<>();
        int fileCount = 0;

        public Folder(String name) {
            this.name = name;
        }

        public void addFolder(Folder folder) {
            folders.add(folder);
        }

        public void addFiles(String file) {
            files.add(file);
            fileCount++;
        }

        public void mergeFiles(Folder folder) {

            files.addAll(folder.files);
            fileCount += folder.fileCount;

        }
    }

    static HashMap<String, Folder> folderHashMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); //폴더의 총 개수
        int M = Integer.parseInt(st.nextToken()); //파일의 총 개수


        for (int i = 1; i <= N + M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String P = st.nextToken(); // 상위 폴더 이름
            String F = st.nextToken(); // 폴더 또는 파일의 이름
            int C = Integer.parseInt(st.nextToken());

            Folder folder = getFolder(P);

            if (C == 1) {
                Folder folder1 = getFolder(F);
                folder.addFolder(folder1);
            } else {
                folder.addFiles(F);
            }
        }

        dfs(getFolder("main"));

        int Q = Integer.parseInt(br.readLine());

        while (Q-- > 0) {
            String path = br.readLine();
            int index = path.lastIndexOf("/");
            if (index != -1) path = path.substring(index + 1);
            Folder folder = folderHashMap.get(path);

            System.out.println(folder.files.size() + " " + folder.fileCount);
        }
    }

    private static void dfs(Folder main) {

        for (Folder next : main.folders) {
            dfs(next);
            main.mergeFiles(next);
        }

    }

    private static Folder getFolder(String p) {
        if (folderHashMap.containsKey(p)) return folderHashMap.get(p);
        Folder folder = new Folder(p);
        folderHashMap.put(p, folder);
        return folder;
    }


}
