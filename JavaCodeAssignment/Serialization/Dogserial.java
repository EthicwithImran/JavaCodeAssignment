import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String Dogname;
    private String Dogbreed;
    private String Ownername;
    private String Ownermob;

    public Person(String Dogname, String Dogbreed, String Ownername, String Ownermob ) {
        this.Dogname = Dogname;
        this.Dogbreed = Dogbreed;
        this.Ownername=Ownername;
        this.Ownermob=Ownermob;
    }

    public String toString() {
        return "Dog Name: " + Dogname + ", Dog Breed: " + Dogbreed +", Owner Name: " + Ownername + ", Owner Mobile No. : " +Ownermob;
    }
}

public class Dogserial {
    public static void main(String[] args) throws ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        List<Person> oldList = new ArrayList<>();

         try {
            FileInputStream fileIn = new FileInputStream("Dogdetail.txt");
            ObjectInputStream objIn = new ObjectInputStream(fileIn);

            oldList = (List<Person>) objIn.readObject();

            objIn.close();
            fileIn.close();

            System.out.println("Objects deserialized from 'Dogdetail.txt':");
            for (Person person : oldList) {
                System.out.println(person);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        // Read input from the user and create objects
        System.out.println("Enter details for people (type 'done' to finish):");
        while (true) {
            System.out.print("Dog Name: ");
            String dogname = scanner.nextLine();
            if (dogname.equalsIgnoreCase("done")) {
                break;
            }

            
            System.out.print("Dog Breed: ");
            String dogbreed = scanner.nextLine();
            System.out.print("Owner Name: ");
            String ownername = scanner.nextLine();
            System.out.print("OWner Mobile No. : ");
            String ownermob = scanner.nextLine();

            Person person = new Person(dogname, dogbreed,ownername,ownermob);
            oldList.add(person);
        }
        scanner.close();

        // Store the objects in a file using serialization
        try {
            FileOutputStream fileOut = new FileOutputStream("Dogdetail.txt");
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);

            objOut.writeObject(oldList);

            objOut.close();
            fileOut.close();

            System.out.println("Objects serialized and stored in 'Dogdetail.txt' successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Later, you can read the objects back from the file (deserialize) and use them as needed.
        // Here's how to read the objects back from the file:
        try {
            FileInputStream fileIn = new FileInputStream("Dogdetail.txt");
            ObjectInputStream objIn = new ObjectInputStream(fileIn);

            List<Person> retrievedPeopleList = (List<Person>) objIn.readObject();

            objIn.close();
            fileIn.close();

            System.out.println("Objects deserialized from 'Dogdetail.txt':");
            for (Person person : retrievedPeopleList) {
                System.out.println(person);
            }
        } catch (IOException e ) {
            e.printStackTrace();
        }
    }
}