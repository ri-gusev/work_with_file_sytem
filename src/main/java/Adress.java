import java.io.Serializable;

public class Adress implements Serializable {
    private String streetName;
    private int numHouse;

    public Adress(String streetName, int numHouse) {
        this.streetName = streetName;
        this.numHouse = numHouse;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getNumHouse() {
        return numHouse;
    }

    public void setNumHouse(int numHouse) {
        this.numHouse = numHouse;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "streetName='" + streetName + '\'' +
                ", numHouse='" + numHouse + '\'' +
                '}';
    }

}
