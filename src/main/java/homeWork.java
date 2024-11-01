import java.io.*;
import java.util.Arrays;
import java.util.List;

public class homeWork {
    public static void main(String[] args) {
        File dir = new File("H-W");
        File file = new File(dir, "Names.txt");
        dir.mkdir();

        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (Reader reader = new InputStreamReader(new FileInputStream(file))) {
            StringBuilder stringBuilder = new StringBuilder();
            int res = reader.read();
            while (res != -1) {
                stringBuilder.append((char) res);
                res = reader.read();
            }
            String[] stringNames = stringBuilder.toString().split(" ");

            List<String> result = Arrays.stream(stringNames)
                    .filter((string) -> string.startsWith("А"))
                    .toList();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
