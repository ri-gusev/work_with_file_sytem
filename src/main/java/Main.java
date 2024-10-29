import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File file = new File("file1.txt");

        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (InputStream inputStream = new FileInputStream(file)){
            int a = inputStream.read();
            while (a != -1){
                System.out.print((char) a);
                a = inputStream.read();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
