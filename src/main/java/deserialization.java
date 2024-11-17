import java.io.*;

public class deserialization {
    public static void main(String[] args) {

        File dir = new File("testFolder");
        File file = new File(dir, "f.txt");

        dir.mkdir();
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        User user = new User("John", "Smith", 25, new Adress("Main", 10));

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))){
            objectOutputStream.writeObject(user);
        }catch (Exception e) {
            e.printStackTrace();
        }

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))){
            User savedUser = (User) objectInputStream.readObject();
            System.out.println(savedUser);
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
