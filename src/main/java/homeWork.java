import java.io.*;
import java.util.Scanner;

public class homeWork {
    public static void main(String[] args) {
        File dir = new File("folderHW");
        File file = new File(dir, "fileHW");
        
        dir.mkdir();
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r")) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter page or \"stop\" to break");
            String page_or_stop = scanner.nextLine();
            while (!page_or_stop.equals("stop")) {
                byte[] one_page = new byte[3000];
                int page = Integer.parseInt(page_or_stop);
                randomAccessFile.seek(page * one_page.length - one_page.length);
                int count = randomAccessFile.read(one_page);
                System.out.println(new String(one_page, 0, count));
                System.out.println("Enter page or \"stop\" to break");
                page_or_stop = scanner.nextLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
