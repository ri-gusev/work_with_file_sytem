import java.io.*;

public class H_W {
    public static void main(String[] args) {
        File dir = new File("folder");
        File file = new File(dir,"file.txt");

        dir.mkdir();
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (InputStream inputStream = new FileInputStream(file)){
            int result_of_read = inputStream.read();
            while (result_of_read != -1){
                System.out.print((char) result_of_read);
                result_of_read = inputStream.read();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
