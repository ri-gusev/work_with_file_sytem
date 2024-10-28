import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
       File dir = new File("folder4/folder3/folder2/folder1");
       File file = new File("folder4/folder3/folder2/folder1/file1.txt");
       File file2 = new File("folder4/folder3/folder2/folder1/file2.txt");
       File file3 = new File("folder4/folder3/folder2/folder1/file3.txt");

        try {
            dir.mkdirs();
            file.createNewFile();
            file2.createNewFile();
            file3.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        File[] files = dir.listFiles(((dir1, name) -> name.contains("1")));

        for(File f : files){
            System.out.println(f.getName());
        }

    }
}
