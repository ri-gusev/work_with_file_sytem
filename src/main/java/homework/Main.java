package homework;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File dir = new File("folderHW");
        File file = new File(dir, "HW.txt");
        dir.mkdir();
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Kesha", "White", 3.5));
        cats.add(new Cat("Muska", "Brown", 4.5));
        cats.add(new Cat("Vasya", "Black", 6.5));

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            for (Cat cat : cats) {
                objectOutputStream.writeObject(cat);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            List<Cat> deserializeCats = new ArrayList<>();

            for (int i = 0; i < cats.size(); i++) {
                Cat cat = (Cat) objectInputStream.readObject();
                deserializeCats.add(cat);
            }

            for (Cat cat : deserializeCats) {
                System.out.println(cat);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
