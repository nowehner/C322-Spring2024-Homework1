package Part3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {

    @Test
    public void testAddGuitar() {
        Inventory inventory = new Inventory();

        // Add a guitar to the inventory
        inventory.addGuitar("123", 999.99, "Builder1", "Model1", "Type1", "BackWood1", "TopWood1");

        // Assuming the guitars_database.txt is updated, you can add assertions here
    }

    @Test
    public void testGetGuitar() {
        Inventory inventory = new Inventory();

        // Add a guitar to the inventory
        inventory.addGuitar("123", 999.99, "Builder1", "Model1", "Type1", "BackWood1", "TopWood1");

        // Retrieve the guitar by serial number
        Guitar retrievedGuitar = inventory.getGuitar("123");

        assertNotNull(retrievedGuitar);
        assertEquals("Builder1", retrievedGuitar.getBuilder());
        // Add more assertions based on the expected values
    }

    @Test
    public void testSearch() {
        Inventory inventory = new Inventory();

        // Add a guitar to the inventory
        inventory.addGuitar("123", 999.99, "Builder1", "Model1", "Type1", "BackWood1", "TopWood1");

        // Search for the guitar by serial number
        Guitar searchedGuitar = inventory.search("123");

        assertNotNull(searchedGuitar);
        assertEquals("Model1", searchedGuitar.getModel());
        // Add more assertions based on the expected values
    }
}
