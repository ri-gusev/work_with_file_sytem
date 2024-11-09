import java.io.*;
import java.util.Scanner;

public class homeWork {
    public static void main(String[] args) {
        File dir = new File("folderHW");
        File file = new File(dir, "fileHW");
        ;
        dir.mkdir();
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file, true))) {
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            while (!name.equals("стоп")) {
                outputStream.write(name.getBytes());
                outputStream.write("\n".getBytes());
                name = scanner.nextLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (Reader reader = new InputStreamReader(new FileInputStream(file))) {
            int res = reader.read();
            StringBuilder stringBuilder = new StringBuilder();
            while (res != -1) {
                stringBuilder.append((char) res);
                res = reader.read();
            }
            System.out.println(stringBuilder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
