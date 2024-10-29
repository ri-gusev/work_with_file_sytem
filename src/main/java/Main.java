import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String path = "folder1/folder2/folder3";

        File dir = new File(path);
        List<File> files = new ArrayList<>();

        files.add(new File(path + "/Sochi.txt"));
        files.add(new File(path + "/Moscow.txt"));
        files.add(new File(path + "/Anapa.txt"));
        files.add(new File(path + "/Armenia.txt"));
        files.add(new File(path + "/astrakhan.txt"));

        dir.mkdirs();
        for(File i : files){
            try {
                i.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        File[] res = dir.listFiles((dir1, name) -> name.startsWith("A") | name.startsWith("a"));

        for (File f : res) {
            System.out.println(f.getAbsolutePath());
        }
    }
}
