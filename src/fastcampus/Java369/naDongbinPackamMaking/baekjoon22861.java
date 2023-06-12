package fastcampus.Java369.naDongbinPackamMaking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon22861 {


    static class Folder {

        String name;
        TreeSet<String> files = new TreeSet<>();
        ArrayList<Folder> folders = new ArrayList<>();

        Folder parent = null;

        int fileCount = 0;

        public Folder(String name) {
            this.name = name;
        }


        public void removeFolder(Folder folder) {
            folders.remove(folder);
        }

        public void addFiles(String addFile) {
            files.add(addFile);
            fileCount++;
        }

        public void addFolders(Folder addFolder) {
            folders.add(addFolder);
        }

        public void mergeFolders(Folder otherFolder) {
            files.addAll(otherFolder.files);
            fileCount += otherFolder.fileCount;
        }


    }


    static HashMap<String, Folder> folderHashMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N + M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String P = st.nextToken();
            String F = st.nextToken();
            int C = Integer.parseInt(st.nextToken());

            Folder parentFolder = getFolder(P);
            if (C == 1) {
                Folder childFolder = getFolder(F);
                parentFolder.addFolders(childFolder);
                childFolder.parent = parentFolder;
            } else {
                parentFolder.addFiles(F);
            }
        }

        int K = Integer.parseInt(br.readLine());

        while (K-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            String folderNameA = st.nextToken();
            String folderNameB = st.nextToken();

            int folderIndexA = folderNameA.lastIndexOf("/");
            int folderIndexB = folderNameB.lastIndexOf("/");

            if (folderIndexA != -1) folderNameA = folderNameA.substring(folderIndexA + 1);
            if (folderIndexB != -1) folderNameB = folderNameB.substring(folderIndexB + 1);


            Folder folderA = getFolder(folderNameA);
            Folder folderB = getFolder(folderNameB);

            for (Folder folder : folderA.folders) {
                folder.parent = folderB;
                folderB.addFolders(folder);
            }
            for (String file : folderA.files) {
                if (folderB.files.contains(file)) continue;
                folderB.addFiles(file);
            }

            folderA.parent.removeFolder(folderA);
            folderHashMap.remove(folderA);
        }

        dfs(getFolder("main"));

        int Q = Integer.parseInt(br.readLine());

        while (Q-- > 0) {
            String path = br.readLine();
            int pathIndex = path.lastIndexOf("/");
            if (pathIndex != -1) path = path.substring(pathIndex + 1);
            Folder folder = getFolder(path);

            System.out.println(folder.files.size() + " " + folder.fileCount);

        }

    }

    private static void dfs(Folder folder) {

        for (Folder next : folder.folders) {
            dfs(next);
            folder.mergeFolders(next);
        }

    }

    private static Folder getFolder(String name) {

        if (folderHashMap.containsKey(name)) return folderHashMap.get(name);
        Folder newFolder = new Folder(name);
        folderHashMap.put(name, newFolder);
        return newFolder;
    }

}
