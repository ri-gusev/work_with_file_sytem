import java.io.*;

public class Main {
    public static void main(String[] args) {

        File dir = new File("folder");
        File file = new File (dir, "file.txt");
        dir.mkdir();
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        Чтение в массив по байтам
//        try (InputStream inputStream = new FileInputStream(file)){
//            byte[] array = new byte[8192];
//            int count = inputStream.read(array);
//            StringBuilder stringBuilder = new StringBuilder();
//            while (count > 0) {
//                stringBuilder.append(new String(array, 0, count));
//                count = inputStream.read(array);
//            }
//            System.out.println(stringBuilder.toString());
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        // чтение по символьно
        try (Reader reader = new InputStreamReader(new FileInputStream(file))){
            int a = reader.read();
            StringBuilder stringBuilder = new StringBuilder();
            while (a != -1) {
                stringBuilder.append((char) a);
                a = reader.read();
            }
            System.out.println(stringBuilder.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
