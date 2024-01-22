package Part3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Inventory extends Guitar {
    private List<Guitar> guitars;

    // Constructor
    public Inventory() {
        super("", 0.0, "", "", "", "", "");
        this.guitars = new ArrayList<>();
    }

    // Function to add a guitar to the list of guitars
    // Function to add a guitar to the list of guitars and write to the text file
    public void addGuitar(String serialNumber, double price, String builder, String model,
                          String type, String backWood, String topWood) {
        Guitar newGuitar = new Guitar(serialNumber, price, builder, model, type, backWood, topWood);
        guitars.add(newGuitar);

        // calls the write to file function to write the new guitar into the inventory on a text file
        writeToFile(newGuitar);
    }

    // writes guitar details to the text file guitars_database.txt
    private void writeToFile(Guitar guitar) {
        try (FileWriter writer = new FileWriter("guitars_database.txt", true)) {
            String guitarDetails = String.format("%s,%f,%s,%s,%s,%s,%s%n",
                    guitar.getSerialNumber(), guitar.getPrice(), guitar.getBuilder(),
                    guitar.getModel(), guitar.getType(), guitar.getBackWood(), guitar.getTopWood());

            writer.write(guitarDetails);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //retrieves a Guitar object by its serial number
    public Guitar getGuitar(String serialNumber) {
        for (Guitar guitar : guitars) {
            if (guitar.getSerialNumber().equals(serialNumber)) {
                return guitar;
            }
        }
        return null; //only if guitar cannot be located
    }

    //searches for a guitar and return a Guitar object
    public Guitar search(String serialNumber) {
        return getGuitar(serialNumber);
    }

    /*public static void main(String[] args) {
        // Create an instance of the Inventory class
        Inventory inventory = new Inventory();

        // Add a guitar to the inventory
        inventory.addGuitar("123", 999.99, "Builder1", "Model1", "Type1", "BackWood1", "TopWood1");

        // Retrieve the guitar by serial number and print its details
        Guitar retrievedGuitar = inventory.getGuitar("123");
        if (retrievedGuitar != null) {
            System.out.println("Retrieved Guitar Details:");
            System.out.println("Serial Number: " + retrievedGuitar.getSerialNumber());
            System.out.println("Builder: " + retrievedGuitar.getBuilder());
            System.out.println("Model: " + retrievedGuitar.getModel());
            // Add more details as needed
        } else {
            System.out.println("Guitar not found in the inventory.");
        }

        // Search for the guitar by serial number and print its details
        Guitar searchedGuitar = inventory.search("123");
        if (searchedGuitar != null) {
            System.out.println("\nSearched Guitar Details:");
            System.out.println("Serial Number: " + searchedGuitar.getSerialNumber());
            System.out.println("Builder: " + searchedGuitar.getBuilder());
            System.out.println("Model: " + searchedGuitar.getModel());
            // Add more details as needed
        } else {
            System.out.println("\nGuitar not found in the inventory.");
        }
    }


     */

}
