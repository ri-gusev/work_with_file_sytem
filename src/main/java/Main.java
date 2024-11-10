import java.io.*;

public class Main {
    public static void main(String[] args) {

        File dir = new File("testFolder");
        File file = new File(dir, "f.txt");

        try (RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw")) {
            randomAccessFile.seek(0);
            byte[] array = new byte[(int) file.length()];
            randomAccessFile.read(array);
            System.out.println(new String(array));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
