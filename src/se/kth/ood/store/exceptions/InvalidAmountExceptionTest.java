package se.kth.ood.store.exceptions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.ood.store.integration.ExternalInventorySystem;

import static org.junit.jupiter.api.Assertions.*;

class InvalidAmountExceptionTest {
    private ExternalInventorySystem externalInventorySystem;
    private int itemID = 1;
    private int invalidAmount = -4;
    private int minimumValidAmount = 1;

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
            externalInventorySystem.getItemByID(itemID, invalidAmount);
            fail("Could enter an invalid amount of items");
        }
        catch(InvalidAmountException e){
            assertTrue(invalidAmount < minimumValidAmount, "InvalidAmountException not caught successfully, "
                        + invalidAmount + " is lower than the minimum valid amount " + minimumValidAmount );
        }
    }



}