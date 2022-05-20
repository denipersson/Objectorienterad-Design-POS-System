package se.kth.ood.store.exceptions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.ood.store.ItemDTO;
import se.kth.ood.store.integration.ExternalInventorySystem;
import se.kth.ood.store.model.Item;

import static org.junit.jupiter.api.Assertions.*;

class ItemMissingExceptionTest {

    private ExternalInventorySystem externalInventorySystem;
    private int invalidItemID = 8888;
    private Item invalidItem = null;

    @BeforeEach
    void setUp() {
        externalInventorySystem = new ExternalInventorySystem();
    }

    @AfterEach
    void tearDown() {
        externalInventorySystem = null;
    }
    @Test
    void testException(){
        try{
            invalidItem = externalInventorySystem.getItemByID(invalidItemID, 1);
            fail("Could enter an invalid invalid item ID");
        }
        catch(ItemMissingException e){
            assertTrue(invalidItem == null, "ItemMissingException not caught successfully, "
                    + invalidItem + " was found with the invalid ID ("+ invalidItemID +"), expected " + null );
        }
    }

}